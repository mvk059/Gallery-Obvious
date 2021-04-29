package com.mvk.galleryobvious.ui.main.utils

import android.widget.ImageView

interface LoadImagesListener {

    fun loadImages(url: String, targetIV: ImageView)
}