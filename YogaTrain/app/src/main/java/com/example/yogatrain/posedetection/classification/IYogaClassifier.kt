package com.example.yogatrain.posedetection.classification

import com.google.mlkit.vision.pose.Pose

interface IYogaClassifier {
    fun classify(pose: Pose): ClassificationResult
    fun confidenceRange(): Float
    fun close()
}
