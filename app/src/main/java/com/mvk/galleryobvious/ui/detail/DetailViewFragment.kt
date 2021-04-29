package com.mvk.galleryobvious.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mvk.galleryobvious.R
import com.mvk.galleryobvious.databinding.DetailViewMainBinding
import com.mvk.galleryobvious.ui.main.SharedViewModel

class DetailViewFragment : Fragment() {

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
        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
    }
}