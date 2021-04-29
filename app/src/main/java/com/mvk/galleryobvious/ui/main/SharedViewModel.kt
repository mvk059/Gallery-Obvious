package com.mvk.galleryobvious.ui.main

import android.content.Context
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.mvk.galleryobvious.data.datasource.ImageDataSource
import com.mvk.galleryobvious.data.model.Image
import com.mvk.galleryobvious.data.model.ImageData
import com.mvk.galleryobvious.data.repository.NetworkRepository

class SharedViewModel() : ViewModel() {
    /**
     * Position of the view pager of the detail screen
     */
    private var viewPagerPosition: Int = 0
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
    fun passDataToDetailFragment(imageData: ImageData) {
        this.imageData = imageData
//        passDataToDetailScreenLD.value = true
    }
}