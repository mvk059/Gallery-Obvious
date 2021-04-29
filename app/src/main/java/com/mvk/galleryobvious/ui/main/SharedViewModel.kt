package com.mvk.galleryobvious.ui.main

import android.content.Context
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.mvk.galleryobvious.data.datasource.ImageDataSource
import com.mvk.galleryobvious.data.model.Image
import com.mvk.galleryobvious.data.repository.NetworkRepository

class SharedViewModel() : ViewModel() {

    /**
     * Gets the data from the data source
     *
     * @return Array of images
     */
    fun getData(context: Context): Array<Image>? {
        val dataSource = ImageDataSource(context)
        return dataSource.getImageData()
    }
}