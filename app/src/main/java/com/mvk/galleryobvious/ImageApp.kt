package com.mvk.galleryobvious

import android.app.Application
import android.widget.ImageView
import com.mvk.galleryobvious.data.remote.LoadImagesServiceImpl

class ImageApp : Application() {

    fun getGlideService(url: String, targetIV: ImageView) =
        LoadImagesServiceImpl.loadImages(url, targetIV)
}