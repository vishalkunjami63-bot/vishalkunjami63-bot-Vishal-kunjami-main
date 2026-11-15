package com.example.data

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PreferencesManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("speakeasy_user_prefs", Context.MODE_PRIVATE)

    private val _userProgress = MutableStateFlow(loadProgress())
    val userProgress: StateFlow<UserProgress> = _userProgress.asStateFlow()

    private fun loadProgress(): UserProgress {
        val userName = prefs.getString("user_name", "Alex Sharma") ?: "Alex Sharma"
        val langId = prefs.getString("selected_lang", AppLanguage.HINDI.name) ?: AppLanguage.HINDI.name
        val selectedLang = try {
            AppLanguage.valueOf(langId)
        } catch (_: Exception) {
            AppLanguage.HINDI
        }
        val totalXp = prefs.getInt("total_xp", 380)
        val dailyStreak = prefs.getInt("daily_streak", 5)
        val dailyGoalXp = prefs.getInt("daily_goal_xp", 50)
        val todayXp = prefs.getInt("today_xp", 35)
        val completedLessons = prefs.getStringSet("completed_lessons", setOf("hi_greet_1", "en_daily_1", "mr_greet_1"))?.toSet()
            ?: setOf("hi_greet_1", "en_daily_1", "mr_greet_1")
        val masteredPhrases = prefs.getStringSet("mastered_phrases", setOf("hi_p1", "hi_p2", "en_p1"))?.toSet()
            ?: setOf("hi_p1", "hi_p2", "en_p1")
        val quizzesCompleted = prefs.getInt("quizzes_completed", 8)
        val speakingAccuracy = prefs.getInt("speaking_accuracy", 92)

        return UserProgress(
            userName = userName,
            selectedLanguage = selectedLang,
            totalXp = totalXp,
            dailyStreak = dailyStreak,
            dailyGoalXp = dailyGoalXp,
            todayXp = todayXp,
            completedLessonIds = completedLessons,
            masteredPhraseIds = masteredPhrases,
            quizzesCompleted = quizzesCompleted,
            speakingAccuracy = speakingAccuracy
        )
    }

    fun setSelectedLanguage(language: AppLanguage) {
        prefs.edit().putString("selected_lang", language.name).apply()
        _userProgress.value = _userProgress.value.copy(selectedLanguage = language)
    }

    fun setUserName(name: String) {
        prefs.edit().putString("user_name", name).apply()
        _userProgress.value = _userProgress.value.copy(userName = name)
    }

    fun addXp(amount: Int) {
        val current = _userProgress.value
        val newTotal = current.totalXp + amount
        val newToday = current.todayXp + amount
        prefs.edit()
            .putInt("total_xp", newTotal)
            .putInt("today_xp", newToday)
            .apply()
        _userProgress.value = current.copy(
            totalXp = newTotal,
            todayXp = newToday
        )
    }

    fun markLessonCompleted(lessonId: String, xpReward: Int = 40) {
        val current = _userProgress.value
        if (!current.completedLessonIds.contains(lessonId)) {
            val updated = current.completedLessonIds + lessonId
            prefs.edit().putStringSet("completed_lessons", updated).apply()
            addXp(xpReward)
            _userProgress.value = _userProgress.value.copy(completedLessonIds = updated)
        }
    }

    fun togglePhraseMastered(phraseId: String, xpReward: Int = 15) {
        val current = _userProgress.value
        val isAlreadyMastered = current.masteredPhraseIds.contains(phraseId)
        val updated = if (isAlreadyMastered) {
            current.masteredPhraseIds - phraseId
        } else {
            addXp(xpReward)
            current.masteredPhraseIds + phraseId
        }
        prefs.edit().putStringSet("mastered_phrases", updated).apply()
        _userProgress.value = _userProgress.value.copy(masteredPhraseIds = updated)
    }

    fun recordQuizCompletion(earnedXp: Int) {
        val current = _userProgress.value
        val newQuizCount = current.quizzesCompleted + 1
        prefs.edit()
            .putInt("quizzes_completed", newQuizCount)
            .apply()
        addXp(earnedXp)
        _userProgress.value = _userProgress.value.copy(quizzesCompleted = newQuizCount)
    }

    fun updateSpeakingAccuracy(score: Int) {
        val current = _userProgress.value
        val newAccuracy = if (current.speakingAccuracy == 0) score else (current.speakingAccuracy + score) / 2
        prefs.edit().putInt("speaking_accuracy", newAccuracy).apply()
        _userProgress.value = _userProgress.value.copy(speakingAccuracy = newAccuracy)
    }

    fun resetProgress() {
        prefs.edit().clear().apply()
        _userProgress.value = UserProgress(
            userName = "Alex Sharma",
            selectedLanguage = AppLanguage.HINDI,
            totalXp = 0,
            dailyStreak = 1,
            dailyGoalXp = 50,
            todayXp = 0,
            completedLessonIds = emptySet(),
            masteredPhraseIds = emptySet(),
            quizzesCompleted = 0,
            speakingAccuracy = 0
        )
    }
}
