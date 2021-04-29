package com.mvk.galleryobvious

import android.app.Application
import android.widget.ImageView
import com.mvk.galleryobvious.data.remote.LoadImagesServiceImpl

class ImageApp : Application() {

    fun getGlideService(url: String, targetIV: ImageView, fullScreenIV: ImageView? = null, source: Int = 0) =
        LoadImagesServiceImpl.loadImages(url, targetIV, fullScreenIV, source)
}