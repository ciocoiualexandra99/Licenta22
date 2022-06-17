package com.example.yogatrain.posedetection.util

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_FLUSH
import com.example.yogatrain.posedetection.classification.YogaPoseClass
import java.util.*

class SpeechManager(context: Context) {
    private var lastSpokenAsana: YogaPoseClass? = null
    private val tts = TextToSpeech(context.applicationContext) {}.apply {
        language = Locale.US
    }

    fun speakAsana(asanaClass: YogaPoseClass) {
        if (asanaClass == YogaPoseClass.UNKNOWN) {
            return
        }

        if (lastSpokenAsana == asanaClass) {
            return
        }

        lastSpokenAsana = asanaClass

        val textToBeSpoken = buildString {
            append("You are doing ")
            append(asanaClass.getFormattedString())
        }
        tts.speak(textToBeSpoken, QUEUE_FLUSH, null, System.currentTimeMillis().toString())
    }

    fun stop() {
        tts.stop()
    }

    fun shutdown() {
        tts.shutdown()
    }
}