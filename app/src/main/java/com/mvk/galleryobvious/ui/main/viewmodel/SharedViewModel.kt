package com.mvk.galleryobvious.ui.main.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.mvk.galleryobvious.data.datasource.ImageDataSource
import com.mvk.galleryobvious.data.model.Image
import com.mvk.galleryobvious.data.model.ImageData

/**
 * Shared View Model for [com.mvk.galleryobvious.ui.main.MainActivity] and
 * [com.mvk.galleryobvious.ui.detail.DetailViewFragment]
 */
class SharedViewModel() : ViewModel() {
    /**
     * Position of the view pager of the detail screen
     */
    var viewPagerPosition: Int = 0
    /**
     * Stores the image data read from the JSON file
     */
    lateinit var imageData: ImageData

    /**
     * Gets the data from the data source
     *
     * @return Array of images
     */
    fun getData(context: Context): Array<Image>? {
        val dataSource = ImageDataSource(context)
        return dataSource.getImageData()
    }

    /**
     * Pass data from main activity to detail fragment
     *
     * @param imageData Array of images
     */
    fun saveImageData(imageData: ImageData) {
        this.imageData = imageData
    }

    /**
     * Pass data from detail fragment to full screen fragment
     */
    fun saveViewPagerPosition(viewPagerPosition: Int) {
        this.viewPagerPosition = viewPagerPosition
    }
}