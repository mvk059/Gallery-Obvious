package com.mvk.galleryobvious.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.mvk.galleryobvious.data.datasource.ImageDataSource
import com.mvk.galleryobvious.data.model.Image

class SharedViewModel(var app: Application) : AndroidViewModel(app) {

    /**
     * Gets the data from the data source
     *
     * @return Array of images
     */
    fun getData(): Array<Image>? {
        val dataSource = ImageDataSource(app)
        return dataSource.getImageData()
    }
}