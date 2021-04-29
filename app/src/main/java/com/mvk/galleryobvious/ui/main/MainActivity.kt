package com.mvk.galleryobvious.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.mvk.galleryobvious.R
import com.mvk.galleryobvious.data.model.ImageData
import com.mvk.galleryobvious.databinding.ActivityMainBinding
import com.mvk.galleryobvious.ui.main.adapter.MainGalleryAdapter
import com.mvk.galleryobvious.utils.common.Constants
import com.mvk.galleryobvious.ui.main.utils.ImageClickListener

class MainActivity : AppCompatActivity(), ImageClickListener {
    /**
     * Binding with the layout file (activity_main.xml) to access it's elements
     */
    private lateinit var binding: ActivityMainBinding

    /**
     * View model for the activity
     */
    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initViewModel()
        setAdapter()
    }

    override fun onClick(imageData: ImageData) {
        Toast.makeText(this, "${imageData.position}", Toast.LENGTH_SHORT).show()
    }

    /**
     * Initialize the view model
     */
    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        binding.mainVM = viewModel
    }

    /**
     * Setting up the adapter to list the images
     */
    private fun setAdapter() {
        val array = viewModel.getData(this)
        val galleryAdapter = MainGalleryAdapter(
            imageList = array,
            imageClickListener = this
        )
        binding.rvMain.apply {
            layoutManager = GridLayoutManager(context, Constants.GRID_SIZE)
            adapter = galleryAdapter
        }
    }
}