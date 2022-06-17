package com.example.yogatrain.posedetection.processor


import android.os.Looper
import android.os.SystemClock
import androidx.annotation.WorkerThread
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageProxy
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.TaskExecutors
import com.google.android.odml.image.MediaMlImageBuilder
import com.google.android.odml.image.MlImage
import com.google.common.base.Preconditions
//import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.mlkit.vision.pose.Pose
import com.google.mlkit.vision.pose.PoseDetection
import com.google.mlkit.vision.pose.PoseDetector
import com.example.yogatrain.extension.showToast
import com.example.yogatrain.posedetection.classification.IYogaClassifier
import com.example.yogatrain.posedetection.detector.DetectorOptions
import com.example.yogatrain.posedetection.latency.Latency
import com.example.yogatrain.posedetection.models.Classification
import com.example.yogatrain.posedetection.models.YogaPoseWithClassification
import com.example.yogatrain.posedetection.utils.CancellableExecutor
import com.example.yogatrain.posedetection.graphic.PoseGraphic
import timber.log.Timber
import java.util.concurrent.Executors

class  PoseDetectorProcessor(
    private val detectorOptions: DetectorOptions
) {
    private val latencyLogger = Latency()

    // Whether this processor is already shut down
    private var isShutdown = false

    private val mainThreadUiExecutor = CancellableExecutor(TaskExecutors.MAIN_THREAD)

    private val classificationExecutor = Executors.newSingleThreadExecutor()
    private var classifier: IYogaClassifier? = null

    private val detector: PoseDetector = PoseDetection.getClient(detectorOptions.getOption())

    @ExperimentalGetImage
    fun processImageProxy(
        image: ImageProxy,
        landMarksOverlay: PoseGraphic,
        onInference: (YogaPoseWithClassification) -> Unit,
        isLoading: (Boolean) -> Unit
    ) {
        val frameStartMs = SystemClock.elapsedRealtime()
        if (isShutdown) {
            image.close()
            return
        }

        val mlImage = MediaMlImageBuilder(image.image!!)
            .setRotation(image.imageInfo.rotationDegrees)
            .build()
        val task = setClassificationCallbacks(
            detectAndClassifyInMLImage(mlImage, isLoading),
            frameStartMs,
            landMarksOverlay,
            onInference
        )

        // Must call image.close() on images when finished using them.
        // Otherwise, new images may not be received or the camera may stall.
        task.addOnCompleteListener { image.close() }
    }

    private fun setClassificationCallbacks(
        task: Task<YogaPoseWithClassification>,
        frameStartMs: Long,
        landMarksOverlay: PoseGraphic,
        onInference: (YogaPoseWithClassification) -> Unit
    ): Task<YogaPoseWithClassification> {
        val detectorStartMs = SystemClock.elapsedRealtime()
        return task.addOnSuccessListener(mainThreadUiExecutor) { results ->
            latencyLogger.notifyDetectorFinished(
                frameStartMs,
                detectorStartMs
            )
            landMarksOverlay.clear()
            onInference(results)
            landMarksOverlay.setPose(results.pose)
            landMarksOverlay.postInvalidate()
        }.addOnFailureListener(mainThreadUiExecutor) { e: Exception ->
            landMarksOverlay.clear()
            val error = "Failed to process. Error: " + e.localizedMessage
            landMarksOverlay.context.showToast("$error \nCause: ${e.cause}")
            Timber.d("Pose detection failed! $error")
            e.printStackTrace()
           // FirebaseCrashlytics.getInstance().recordException(e)
        }
    }

    private fun detectAndClassifyInMLImage(
        image: MlImage,
        isLoading: (Boolean) -> Unit
    ): Task<YogaPoseWithClassification> {
        val detectorStart = SystemClock.elapsedRealtime()
        val processImageTask = detector.process(image).addOnCompleteListener {
            latencyLogger.logDetectionTime(detectorStart)
        }
        return processImageTask.continueWith(classificationExecutor) { task ->
            val pose = task.result
            loadClassifier(isLoading)
            val classifierStart = SystemClock.elapsedRealtime()
            val classification = classifyAsanaFromPose(pose)
            latencyLogger.logClassifierTime(classifierStart)
            YogaPoseWithClassification(pose, classification)
        }
    }

    fun stop() {
        mainThreadUiExecutor.shutdown()
        isShutdown = true
        latencyLogger.reset()
        detector.close()
    }

    private fun loadClassifier(isLoading: (Boolean) -> Unit) {
        isLoading(true)
        classifier?.close()
        this.classifier = detectorOptions.getClassifier()
        isLoading(false)
    }

    @WorkerThread
    private fun classifyAsanaFromPose(pose: Pose): Classification {
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper())
        val classification = classifier!!.classify(pose)

        val maxConfidenceClass = classification.getMaxConfidenceClass()
        val confidence = (classification.getClassConfidence(maxConfidenceClass)
                / classifier!!.confidenceRange())
        return Classification(maxConfidenceClass, confidence)
    }
}