package com.mvk.galleryobvious.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.mvk.galleryobvious.R
import com.mvk.galleryobvious.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
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
    }

    /**
     * Initialize the view model
     */
    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)
        binding.mainVM = viewModel
    }
}