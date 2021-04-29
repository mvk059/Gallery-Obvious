package com.mvk.galleryobvious.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mvk.galleryobvious.R
import com.mvk.galleryobvious.data.model.ImageData
import com.mvk.galleryobvious.databinding.DetailViewMainBinding
import com.mvk.galleryobvious.ui.detail.adapter.DetailViewAdapter
import com.mvk.galleryobvious.ui.detail.utils.FullScreenClickListener
import com.mvk.galleryobvious.ui.fullscreen.FullScreenFragment
import com.mvk.galleryobvious.ui.main.SharedViewModel
import com.mvk.galleryobvious.utils.common.replaceFragment

class DetailViewFragment : Fragment(), FullScreenClickListener {

    /**
     * Binding with the layout file (detail_view_main.xml) to access it's elements
     */
    private lateinit var binding: DetailViewMainBinding
    /**
     * View model for the fragment
     */
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_view_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter(viewModel.imageData)
    }

    override fun onClick(viewPagerPosition: Int, fullScreenIV: ImageView) {
        replaceFragment(
            fragment = FullScreenFragment(),
            container = android.R.id.content
        )
        viewModel.saveViewPagerPosition(viewPagerPosition)
    }

    /**
     * Setting up the adapter to list the images
     * Navigating to the position of the selected image
     */
    private fun initAdapter(it: ImageData) {
        binding.detailViewPager.adapter = DetailViewAdapter(it, this)
        binding.detailViewPager.setCurrentItem(it.position, false)
    }
}