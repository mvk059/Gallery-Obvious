package com.mvk.galleryobvious

import android.app.Application
import android.widget.ImageView
import com.mvk.galleryobvious.data.remote.LoadImagesServiceImpl

/**
 * Application class
 */
class ImageApp : Application() {

    /**
     * Call the Glide service via [com.mvk.galleryobvious.data.remote.LoadImagesServiceImpl] interface
     *
     * @param url URL of the image to load
     * @param targetIV Image view to load the downloaded image
     * @param fullScreenIV Full screen image view reference to be enabled when image has been downloaded
     * @param source App screen ID
     */
    fun getGlideService(url: String, targetIV: ImageView, fullScreenIV: ImageView? = null, source: Int = 0) =
        LoadImagesServiceImpl.loadImages(url, targetIV, fullScreenIV, source)
}