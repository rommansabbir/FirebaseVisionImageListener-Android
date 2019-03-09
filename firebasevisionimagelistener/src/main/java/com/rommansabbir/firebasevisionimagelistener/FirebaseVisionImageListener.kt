package com.rommansabbir.firebasevisionimagelistener

import android.content.Context
import android.graphics.Bitmap
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.label.FirebaseVisionLabel
import kotlin.collections.ArrayList

class FirebaseVisionImageListener(context: Context) {
    private val TAG = "ImageListener"
    private var mContext : Context = context
    private var firebaseVisionImageListenerInterface: FirebaseVisionImageListenerInterface
    private lateinit var labelsList : ArrayList<String>

    init {
        firebaseVisionImageListenerInterface = mContext as FirebaseVisionImageListenerInterface
    }

    fun getLabelsFromImage(bitmap: Bitmap) {
        val image = FirebaseVisionImage.fromBitmap(bitmap)
        labelsList = ArrayList<String>()
        val detector = FirebaseVision.getInstance().getVisionLabelDetector()

        detector.detectInImage(image).addOnSuccessListener(
                object : OnSuccessListener<List<FirebaseVisionLabel>> {
                    override fun onSuccess(labels: List<FirebaseVisionLabel>) {
                        for (label in labels) {
                            labelsList.add(label.label.toString())
                        }
                        firebaseVisionImageListenerInterface.onFirebaseVisionImageSuccess(labelsList)
                    }
                })
                .addOnFailureListener(
                        object : OnFailureListener {
                            override fun onFailure(e: Exception) {
                                firebaseVisionImageListenerInterface.onFirebaseVisionImageFailure(e)
                            }
                        })
    }

    interface FirebaseVisionImageListenerInterface{
        fun onFirebaseVisionImageSuccess(labelsList: List<String>)
        fun onFirebaseVisionImageFailure(exception : java.lang.Exception)
    }
}


