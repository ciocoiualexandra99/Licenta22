package com.example.yogatrain.posedetection.classification

import android.content.Context
import com.example.yogatrain.ml.ModelV3
import com.google.mlkit.vision.pose.Pose
import com.example.yogatrain.posedetection.utils.PoseEmbeddingUtils
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class TFLiteAsanaClassifier(context: Context) : IYogaClassifier {
    private val model = ModelV3.newInstance(context)

    override fun classify(pose: Pose): ClassificationResult {
        val classificationResult = ClassificationResult()
        if (pose.allPoseLandmarks.isEmpty()) {
            return classificationResult
        }

        val inputFeature = TensorBuffer.createFixedSize(intArrayOf(1, 69), DataType.FLOAT32)
        val inputPose =
            PoseEmbeddingUtils.getPoseEmbedding(pose.allPoseLandmarks.map { it.position3D })
        val unzippedList = mutableListOf<Float>()
        inputPose.forEach {
            unzippedList.add(it.x)
            unzippedList.add(it.y)
            unzippedList.add(it.z)
        }
        inputFeature.loadArray(unzippedList.toFloatArray())
        val outputs = model.process(inputFeature)
        val output = outputs.outputFeature0AsTensorBuffer
        // Maintain same order as [labels_list] used while training
        val classes = listOf(
            YogaPoseClass.adho_mukha_svanasana,
            YogaPoseClass.bhujangasana,
            YogaPoseClass.bidalasana,
            YogaPoseClass.phalakasana,
            YogaPoseClass.ustrasana,
            YogaPoseClass.utkatasana,
            YogaPoseClass.utkata_konasana,
            YogaPoseClass.virabhadrasana_i,
            YogaPoseClass.virabhadrasana_ii,
            YogaPoseClass.vrikshasana
        )
        output.floatArray.forEachIndexed { index: Int, fl: Float ->
            classificationResult.putClassConfidence(classes[index], fl)
        }
        return classificationResult
    }

    override fun confidenceRange(): Float {
        return 0.01f
    }

    override fun close() {
        model.close()
    }
}