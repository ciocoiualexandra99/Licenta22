package com.example.yogatrain.posedetection.util

import com.example.yogatrain.posedetection.classification.YogaPoseClass
import com.example.yogatrain.posedetection.detector.DetectorOptions
import com.example.yogatrain.posedetection.models.Classification
import com.example.yogatrain.posedetection.models.YogaPoseWithClassification

class ResultSmoothing {
    private val lastCachedResults = mutableListOf<Classification>()

    fun getMajorityPose(): Classification {
        val asanaGrouped = lastCachedResults.groupingBy { it.asanaClass }.eachCount()
        val maxFrequencyAsana =
            asanaGrouped.maxWithOrNull { e1, e2 -> e1.value.compareTo(e2.value) }?.key
                ?: return Classification(YogaPoseClass.UNKNOWN, 100f)

        return lastCachedResults
            .filter {
                it.asanaClass == maxFrequencyAsana
                        && it.confidence > DetectorOptions.LANDMARK_CONF_THRESHOLD / 0.01f
            }
            .maxByOrNull { it.confidence }
            ?: return Classification(YogaPoseClass.UNKNOWN, 100f)
    }

    fun setInferredPose(poseWithAsanaClassification: YogaPoseWithClassification) {
        checkFrameCountAndFlush()
        lastCachedResults.add(poseWithAsanaClassification.classification)
    }

    fun clearCache() {
        lastCachedResults.clear()
    }

    private fun checkFrameCountAndFlush() {
        if (lastCachedResults.size > FLUSH_FRAME_COUNT) {
            clearCache()
        }
    }

    companion object {
        private const val FLUSH_FRAME_COUNT = 60
    }
}