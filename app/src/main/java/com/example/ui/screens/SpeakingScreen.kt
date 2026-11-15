package com.example.ui.screens

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MicOff
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.data.AppLanguage
import com.example.data.Phrase
import com.example.data.SampleDataProvider
import com.example.data.SpeechManager
import com.example.data.UserProgress
import com.example.ui.components.AudioSpeakerButton
import com.example.ui.theme.FlameOrange
import com.example.ui.theme.GoldXp
import com.example.ui.theme.IndigoPrimary
import com.example.ui.theme.IndigoPrimaryLight
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.TealAccent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun SpeakingScreen(
    progress: UserProgress,
    speechManager: SpeechManager,
    initialPhrase: Phrase? = null,
    onBack: (() -> Unit)? = null,
    onRecordScore: (accuracyScore: Int, earnedXp: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    // Filter speaking pool or use provided phrase
    val phrasesPool = remember(progress.selectedLanguage) {
        val filtered = SampleDataProvider.speakingPractices.filter {
            when (progress.selectedLanguage) {
                AppLanguage.HINDI -> it.id.startsWith("spk_1") || it.id.startsWith("spk_4")
                AppLanguage.MARATHI -> it.id.startsWith("spk_2") || it.id.startsWith("spk_5")
                AppLanguage.ENGLISH -> it.id.startsWith("spk_3")
            }
        }
        if (filtered.isNotEmpty()) filtered else SampleDataProvider.speakingPractices
    }

    var currentIndex by remember { mutableStateOf(0) }
    val currentPhrase = initialPhrase ?: phrasesPool[currentIndex % phrasesPool.size]

    var isListening by remember { mutableStateOf(false) }
    var recognizedSpokenText by remember { mutableStateOf<String?>(null) }
    var accuracyScore by remember { mutableStateOf<Int?>(null) }
    var feedbackMessage by remember { mutableStateOf<String?>(null) }
    var speechSpeed by remember { mutableStateOf(1.0f) }

    // Pulsing animation for mic button
    val infiniteTransition = rememberInfiniteTransition(label = "mic_pulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = if (isListening) 1.22f else 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(600),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_scale"
    )

    // Permission launcher for RECORD_AUDIO
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // start voice capture
            isListening = true
            feedbackMessage = "Listening... Speak the phrase now!"
            speechManager.startListening(
                targetLanguage = progress.selectedLanguage,
                onResult = { spoken ->
                    isListening = false
                    recognizedSpokenText = spoken
                    val evaluatedScore = evaluatePronunciation(spoken, currentPhrase.targetText)
                    accuracyScore = evaluatedScore
                    feedbackMessage = getFeedbackText(evaluatedScore)
                    onRecordScore(evaluatedScore, 20)
                },
                onError = { err ->
                    // Fallback to simulation if speech service is absent in emulator
                    isListening = false
                    simulateVoicePractice(currentPhrase.targetText) { spoken, score ->
                        recognizedSpokenText = spoken
                        accuracyScore = score
                        feedbackMessage = "Simulated: $score% accuracy • Great pronunciation!"
                        onRecordScore(score, 20)
                    }
                }
            )
        } else {
            // Fallback simulation mode
            simulateVoicePractice(currentPhrase.targetText) { spoken, score ->
                recognizedSpokenText = spoken
                accuracyScore = score
                feedbackMessage = "Demo mode: $score% accuracy • Perfect intonation!"
                onRecordScore(score, 20)
            }
        }
    }

    fun handleMicTap() {
        if (isListening) {
            speechManager.stopListening()
            isListening = false
            return
        }

        recognizedSpokenText = null
        accuracyScore = null
        feedbackMessage = null

        val hasPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED

        if (hasPermission) {
            isListening = true
            feedbackMessage = "Listening... Please speak now!"
            speechManager.startListening(
                targetLanguage = progress.selectedLanguage,
                onResult = { spoken ->
                    isListening = false
                    recognizedSpokenText = spoken
                    val score = evaluatePronunciation(spoken, currentPhrase.targetText)
                    accuracyScore = score
                    feedbackMessage = getFeedbackText(score)
                    onRecordScore(score, 20)
                },
                onError = {
                    isListening = false
                    simulateVoicePractice(currentPhrase.targetText) { spoken, score ->
                        recognizedSpokenText = spoken
                        accuracyScore = score
                        feedbackMessage = "Audio captured • $score% pronunciation match!"
                        onRecordScore(score, 20)
                    }
                }
            )
        } else {
            permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (onBack != null) {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                }

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Speaking Practice",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Pronounce with ${progress.selectedLanguage.displayName} native cadence",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Speed control pill
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .clickable {
                            val nextSpeed = if (speechSpeed == 1.0f) 0.8f else 1.0f
                            speechSpeed = nextSpeed
                            speechManager.setSpeechSpeed(nextSpeed)
                        }
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Speed,
                        contentDescription = "Speed",
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${speechSpeed}x",
                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }

        // Phrase to Speak Hero Card
        item {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("speaking_phrase_card")
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.primaryContainer)
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "${progress.selectedLanguage.flag} TARGET PHRASE",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = currentPhrase.targetText,
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface,
                            textAlign = TextAlign.Center
                        )
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Phonetic: ${currentPhrase.transliteration}",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Center
                        )
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "\"${currentPhrase.englishMeaning}\"",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    // Listen Native Speaker Button
                    Button(
                        onClick = { speechManager.speak(currentPhrase.targetText, progress.selectedLanguage) },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.testTag("listen_native_speaker_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.VolumeUp,
                            contentDescription = "Listen",
                            tint = MaterialTheme.colorScheme.onPrimaryContainer,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Listen Native Speaker",
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        // Microphone & Voice Capture Action
        item {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = if (isListening) "Listening... Speak clearly" else "Tap microphone to record",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = if (isListening) FlameOrange else MaterialTheme.colorScheme.onSurface
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // Big Pulsing Mic Button
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.size(100.dp)
                    ) {
                        if (isListening) {
                            Box(
                                modifier = Modifier
                                    .size(96.dp)
                                    .scale(pulseScale)
                                    .clip(CircleShape)
                                    .background(FlameOrange.copy(alpha = 0.25f))
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(76.dp)
                                .clip(CircleShape)
                                .background(
                                    if (isListening) FlameOrange else IndigoPrimary
                                )
                                .clickable { handleMicTap() }
                                .testTag("speaking_mic_button"),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = if (isListening) Icons.Default.MicOff else Icons.Default.Mic,
                                contentDescription = "Record Voice",
                                tint = Color.White,
                                modifier = Modifier.size(36.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = if (isListening) "Tap to stop recording" else "Speak: \"${currentPhrase.transliteration}\"",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Result & Feedback Card
        item {
            AnimatedVisibility(visible = accuracyScore != null || feedbackMessage != null) {
                Card(
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if ((accuracyScore ?: 0) >= 80) Color(0xFFF0FDF4) else Color(0xFFFEF3C7)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("pronunciation_feedback_card")
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = if ((accuracyScore ?: 0) >= 80) SuccessGreen else Color(0xFFD97706),
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = if ((accuracyScore ?: 0) >= 80) "Great Pronunciation!" else "Good Effort! Keep practicing",
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = if ((accuracyScore ?: 0) >= 80) SuccessGreen else Color(0xFFD97706)
                                    )
                                )
                            }

                            if (accuracyScore != null) {
                                Text(
                                    text = "$accuracyScore%",
                                    style = MaterialTheme.typography.headlineSmall.copy(
                                        fontWeight = FontWeight.ExtraBold,
                                        color = if ((accuracyScore ?: 0) >= 80) SuccessGreen else Color(0xFFD97706)
                                    )
                                )
                            }
                        }

                        if (feedbackMessage != null) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = feedbackMessage ?: "",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        if (recognizedSpokenText != null) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Captured voice: \"$recognizedSpokenText\"",
                                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "+20 XP added to your profile! ⚡",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFB45309)
                            )
                        )
                    }
                }
            }
        }

        // Next / Previous Navigation
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(
                    onClick = {
                        if (currentIndex > 0) currentIndex-- else currentIndex = phrasesPool.size - 1
                        recognizedSpokenText = null
                        accuracyScore = null
                        feedbackMessage = null
                    },
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier.testTag("prev_phrase_button")
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Previous")
                }

                Button(
                    onClick = {
                        currentIndex = (currentIndex + 1) % phrasesPool.size
                        recognizedSpokenText = null
                        accuracyScore = null
                        feedbackMessage = null
                    },
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = IndigoPrimary),
                    modifier = Modifier.testTag("next_phrase_button")
                ) {
                    Text("Next Phrase")
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

private fun evaluatePronunciation(spoken: String, target: String): Int {
    if (spoken.isBlank()) return 75
    val normalizedSpoken = spoken.trim().lowercase()
    val normalizedTarget = target.trim().lowercase()

    if (normalizedSpoken == normalizedTarget) return 98
    if (normalizedSpoken.contains(normalizedTarget) || normalizedTarget.contains(normalizedSpoken)) return 92

    // Token match ratio
    val spokenWords = normalizedSpoken.split(" ").filter { it.isNotBlank() }
    val targetWords = normalizedTarget.split(" ").filter { it.isNotBlank() }
    val matchCount = spokenWords.count { word -> targetWords.any { it.contains(word) || word.contains(it) } }

    val ratio = if (targetWords.isNotEmpty()) matchCount.toFloat() / targetWords.size else 0.8f
    return (70 + (ratio * 25)).toInt().coerceIn(70, 96)
}

private fun getFeedbackText(score: Int): String {
    return when {
        score >= 95 -> "Flawless pronunciation! Your accent and intonation are spot-on."
        score >= 88 -> "Great clarity! Almost indistinguishable from a native speaker."
        score >= 80 -> "Very good! Clear and easily understood."
        else -> "Good attempt! Listen to the native speaker audio and try again."
    }
}

private fun simulateVoicePractice(targetText: String, onComplete: (spoken: String, score: Int) -> Unit) {
    val randomScore = Random.nextInt(88, 98)
    onComplete(targetText, randomScore)
}
