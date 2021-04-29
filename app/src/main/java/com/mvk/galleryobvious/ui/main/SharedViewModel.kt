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
     * Stores the image data read from the JSON file
     */
    var imageData: Array<Image>? = arrayOf()

    /**
     * Gets the data from the data source
     *
     * @return Array of images
     */
    fun getData(context: Context): Array<Image>? {
        val dataSource = ImageDataSource(context)
        imageData = dataSource.getImageData()
        return imageData
    }
}