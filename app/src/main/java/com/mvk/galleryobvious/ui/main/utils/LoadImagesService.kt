package com.mvk.galleryobvious.ui.main.utils

import android.widget.ImageView

interface LoadImagesService {

    fun loadImages(url: String, targetIV: ImageView, sourceType: Int)
}