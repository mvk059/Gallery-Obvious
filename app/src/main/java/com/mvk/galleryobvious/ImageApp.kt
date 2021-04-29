package com.mvk.galleryobvious

import android.app.Application
import android.widget.ImageView
import com.mvk.galleryobvious.data.remote.LoadImagesListenerImpl

class ImageApp : Application() {

    fun getGlideService(url: String, targetIV: ImageView) =
        LoadImagesListenerImpl.loadImages(url, targetIV)
}