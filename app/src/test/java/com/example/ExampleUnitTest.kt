package com.example

import com.example.data.AppLanguage
import com.example.data.SampleDataProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun sampleData_containsAllThreeLanguages() {
        val languages = SampleDataProvider.categories.map { it.language }.distinct()
        assertTrue(languages.contains(AppLanguage.HINDI))
        assertTrue(languages.contains(AppLanguage.MARATHI))
        assertTrue(languages.contains(AppLanguage.ENGLISH))
    }

    @Test
    fun sampleData_phrasesHaveMeaningsAndExamples() {
        SampleDataProvider.categories.forEach { category ->
            category.lessons.forEach { lesson ->
                assertTrue(lesson.phrases.isNotEmpty())
                lesson.phrases.forEach { phrase ->
                    assertTrue(phrase.targetText.isNotBlank())
                    assertTrue(phrase.transliteration.isNotBlank())
                    assertTrue(phrase.englishMeaning.isNotBlank())
                    assertTrue(phrase.exampleTarget.isNotBlank())
                }
            }
        }
    }

    @Test
    fun sampleData_quizzesExistForAllLanguages() {
        AppLanguage.values().forEach { lang ->
            val langQuizzes = SampleDataProvider.quizzes.filter { it.language == lang }
            assertTrue("Quizzes should exist for ${lang.displayName}", langQuizzes.isNotEmpty())
            langQuizzes.forEach { q ->
                assertTrue(q.options.isNotEmpty())
                assertTrue(q.correctIndex in q.options.indices)
            }
        }
    }
}
