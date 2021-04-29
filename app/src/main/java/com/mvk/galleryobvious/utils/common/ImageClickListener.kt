package com.mvk.galleryobvious.utils.common

import com.mvk.galleryobvious.data.model.ImageData

/**
 * Interface to handle clicks of images
 */
interface ImageClickListener {

    fun onClick(imageData: ImageData)
}