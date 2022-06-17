package com.example.yogatrain.posedetection.classification

import java.util.*

class ClassificationResult {
    private val classConfidences: MutableMap<YogaPoseClass, Float> = EnumMap(YogaPoseClass::class.java)

    fun getClassConfidence(yogaposeClass: YogaPoseClass): Float {
        return classConfidences[yogaposeClass] ?: 0f
    }

    // Gets first entry if same confidence
    fun getMaxConfidenceClass(): YogaPoseClass {
        return classConfidences.maxWithOrNull { e1, e2 ->
            e1.value.compareTo(e2.value)
        }?.key ?: YogaPoseClass.UNKNOWN
    }

    fun putClassConfidence(yogaposeClass: YogaPoseClass, confidence: Float) {
        classConfidences[yogaposeClass] = confidence
    }
}
