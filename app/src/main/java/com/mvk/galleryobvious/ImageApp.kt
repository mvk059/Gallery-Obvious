package com.mvk.galleryobvious

import android.app.Application
import com.mvk.galleryobvious.data.remote.ImageServiceImpl
import com.mvk.galleryobvious.ui.main.utils.ImageService

/**
 * Application class
 */
class ImageApp : Application() {

    companion object {
        // Image service to load images
        val imageService: ImageService = ImageServiceImpl
    }
}