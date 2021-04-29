package com.mvk.galleryobvious.ui.detail.utils

/**
 * Interface to handle navigation to full screen
 */
interface FullScreenClickListener {

    /**
     * Handles full screen button click
     *
     * @param viewPagerPosition View pager position of the full screen image
     */
    fun onClick(viewPagerPosition: Int)
}