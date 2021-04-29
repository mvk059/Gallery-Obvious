package com.mvk.galleryobvious.ui.main.utils

import android.widget.ImageView

/**
 * Interface to handle loading of images via Glide
 */
interface LoadImagesService {

    /**
     * Load images via Glide
     *
     * @param url URL of the image to load
     * @param targetIV Image view to load the downloaded image
     * @param fullScreenIV Full screen image view reference to be enabled when image has been downloaded
     * @param source App screen ID
     */
    fun loadImages(url: String, targetIV: ImageView, fullScreenIV: ImageView?, source: Int)
}