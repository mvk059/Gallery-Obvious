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
import com.mvk.galleryobvious.ui.main.SharedViewModel
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
     * Initializes the required observers
     */
    private fun loadImageInFullScreen() {
        val url = viewModel.imageData.image[viewModel.viewPagerPosition].url
        (context?.applicationContext as ImageApp).getGlideService(
            url = url,
            targetIV = binding.fullIV,
            source = Constants.SOURCE_FULL_SCREEN
        )
        activity?.window?.decorView?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LOW_PROFILE or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }


}