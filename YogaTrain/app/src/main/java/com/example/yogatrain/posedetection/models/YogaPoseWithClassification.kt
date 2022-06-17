package com.example.yogatrain.posedetection.models


import com.google.mlkit.vision.pose.Pose
import com.example.yogatrain.posedetection.classification.YogaPoseClass

data class YogaPoseWithClassification(
    val pose: Pose,
    val classification: Classification
)

data class Classification(
    val asanaClass: YogaPoseClass,
    val confidence: Float
)