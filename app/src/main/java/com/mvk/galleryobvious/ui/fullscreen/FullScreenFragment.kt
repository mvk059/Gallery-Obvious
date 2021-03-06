package com.mvk.galleryobvious.ui.fullscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mvk.galleryobvious.ImageApp
import com.mvk.galleryobvious.R
import com.mvk.galleryobvious.databinding.FullScreenViewMainBinding
import com.mvk.galleryobvious.ui.main.viewmodel.SharedViewModel
import com.mvk.galleryobvious.utils.common.Constants

/**
 * Full Screen fragment to display the HD version of the selected image
 */
class FullScreenFragment : Fragment() {

    /**
     * Binding with the layout file (full_screen_view_main.xml) to access it's elements
     */
    private lateinit var binding: FullScreenViewMainBinding

    /**
     * View model for the fragment
     */
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.full_screen_view_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadImageInFullScreen()
    }

    /**
     * Load the HD image in full screen
     */
    private fun loadImageInFullScreen() {
        val url = viewModel.imageData.image[viewModel.viewPagerPosition].hdurl
        ImageApp.imageService.loadImages(
            url = url,
            targetIV = binding.fullIV,
            source = Constants.SOURCE_FULL_SCREEN
        )
    }

}