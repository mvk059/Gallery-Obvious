package com.mvk.galleryobvious.ui.detail.utils

import android.widget.ImageView

/**
 * Interface to handle navigation to full screen
 */
interface FullScreenClickListener {

    fun onClick(viewPagerPosition: Int, fullScreenIV: ImageView)
}