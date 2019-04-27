package com.rommansabbir.GetLabelsFromImage_Firebase

interface GetLabelsFromImageCallback {
    fun onGetLabelsSuccess(labelsList: List<String>)
    fun onGetLabelsFailure(exception : java.lang.Exception)
}