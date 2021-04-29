package com.mvk.galleryobvious.ui.main.utils

import com.mvk.galleryobvious.data.model.ImageData

/**
 * Interface to handle clicks of images
 */
interface ImageClickListener {

    /**
     * Handle click event in [com.mvk.galleryobvious.ui.main.MainActivity]
     *
     * @param imageData List of images
     */
    fun onClick(imageData: ImageData)
}