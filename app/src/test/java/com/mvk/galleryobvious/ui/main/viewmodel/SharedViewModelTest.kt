package com.mvk.galleryobvious.ui.main.viewmodel

import com.google.gson.GsonBuilder
import com.mvk.galleryobvious.data.model.Image
import com.mvk.galleryobvious.data.model.ImageData
import com.mvk.galleryobvious.utils.ImageDataJSON
import io.mockk.MockKAnnotations
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class SharedViewModelTest {

    lateinit var viewModel: SharedViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = SharedViewModel()
    }

    @Test
    fun saveImageData() {
        val imageData = getImageData()?.let { ImageData(it, 1) }
        imageData?.let { viewModel.saveImageData(it) }
        assertEquals(imageData, viewModel.imageData)
    }

    @Test
    fun saveViewPagerPosition() {
        val viewPagerPosition = 5
        viewModel.saveViewPagerPosition(viewPagerPosition)
        assertEquals(viewPagerPosition, viewModel.viewPagerPosition)
    }

    private fun getImageData(): Array<Image>? {
        val json = ImageDataJSON.imageDataJson
        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.create()
        return gson.fromJson(json, Array<Image>::class.java)
    }
}