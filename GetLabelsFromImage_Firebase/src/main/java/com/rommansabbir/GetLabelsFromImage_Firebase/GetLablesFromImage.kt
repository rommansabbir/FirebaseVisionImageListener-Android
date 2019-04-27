package com.rommansabbir.GetLabelsFromImage_Firebase

import android.graphics.Bitmap
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import kotlin.collections.ArrayList

object GetLablesFromImage {
    private const val TAG = "ImageListener"
    private lateinit var labelsList : ArrayList<String>

    /**
     * This method is responsible to extract labels from image
     * using firebase vision image SDK
     * @param imageToExtractBitmap, the bitmap format of your selected image
     * @param callback, provide callback to get notified [GetLabelsFromImageCallback]
     */
    fun getLabelsFromImage(imageToExtractBitmap: Bitmap, callback : GetLabelsFromImageCallback) {
        val image = FirebaseVisionImage.fromBitmap(imageToExtractBitmap)
        labelsList = ArrayList<String>()
        val detector = FirebaseVision.getInstance().visionLabelDetector
        detector.detectInImage(image).addOnSuccessListener { labels ->
            for (label in labels) {
                labelsList.add(label.label.toString())
            }
            callback.onGetLabelsSuccess(labelsList)
        }.addOnFailureListener { e -> callback.onGetLabelsFailure(e) }
    }
}



