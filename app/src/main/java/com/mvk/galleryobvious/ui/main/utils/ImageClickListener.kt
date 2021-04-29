package com.mvk.galleryobvious.ui.main.utils

import com.mvk.galleryobvious.data.model.ImageData

/**
 * Interface to handle clicks of images
 */
interface ImageClickListener {

    fun onClick(imageData: ImageData)
}