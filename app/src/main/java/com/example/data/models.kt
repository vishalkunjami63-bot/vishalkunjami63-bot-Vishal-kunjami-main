package com.example.data

enum class AppLanguage(
    val id: String,
    val displayName: String,
    val nativeName: String,
    val flag: String,
    val ttsLanguageTag: String
) {
    ENGLISH(
        id = "english",
        displayName = "English",
        nativeName = "English",
        flag = "🇬🇧",
        ttsLanguageTag = "en-US"
    ),
    HINDI(
        id = "hindi",
        displayName = "Hindi",
        nativeName = "हिन्दी",
        flag = "🇮🇳",
        ttsLanguageTag = "hi-IN"
    ),
    MARATHI(
        id = "marathi",
        displayName = "Marathi",
        nativeName = "मराठी",
        flag = "🚩",
        ttsLanguageTag = "mr-IN"
    )
}

enum class DifficultyLevel {
    BEGINNER, INTERMEDIATE, ADVANCED
}

data class Phrase(
    val id: String,
    val targetText: String,
    val scriptText: String, // Devanagari or English text
    val transliteration: String, // Phonetic pronunciation guide
    val englishMeaning: String,
    val nativeMeaning: String,
    val exampleTarget: String,
    val exampleMeaning: String,
    val audioHint: String = "",
    val xpReward: Int = 15
)

data class LessonCategory(
    val id: String,
    val language: AppLanguage,
    val title: String,
    val nativeTitle: String,
    val icon: String,
    val description: String,
    val level: DifficultyLevel,
    val lessons: List<Lesson>
)

data class Lesson(
    val id: String,
    val categoryId: String,
    val title: String,
    val nativeTitle: String,
    val summary: String,
    val phrases: List<Phrase>,
    val xpReward: Int = 40
)

data class QuizQuestion(
    val id: String,
    val language: AppLanguage,
    val question: String,
    val phraseToPlay: String? = null,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String,
    val xpValue: Int = 10
)

data class AchievementBadge(
    val id: String,
    val title: String,
    val description: String,
    val icon: String,
    val isUnlocked: Boolean,
    val requiredXp: Int
)

data class UserProgress(
    val userName: String = "Alex Sharma",
    val selectedLanguage: AppLanguage = AppLanguage.HINDI,
    val totalXp: Int = 380,
    val dailyStreak: Int = 5,
    val dailyGoalXp: Int = 50,
    val todayXp: Int = 35,
    val dailyGoalMinutes: Int = 15,
    val todayMinutes: Int = 9,
    val completedLessonIds: Set<String> = setOf("hi_greet_1", "en_daily_1", "mr_greet_1"),
    val masteredPhraseIds: Set<String> = setOf("hi_p1", "hi_p2", "en_p1"),
    val quizzesCompleted: Int = 8,
    val speakingAccuracy: Int = 92
)
