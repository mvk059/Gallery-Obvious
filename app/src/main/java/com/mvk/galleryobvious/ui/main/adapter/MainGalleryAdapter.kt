package com.mvk.galleryobvious.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvk.galleryobvious.ImageApp
import com.mvk.galleryobvious.data.model.Image
import com.mvk.galleryobvious.data.model.ImageData
import com.mvk.galleryobvious.databinding.ItemViewHomeMainBinding
import com.mvk.galleryobvious.ui.main.utils.ImageClickListener

class MainGalleryAdapter(
    var imageList: Array<Image>?,
    var imageClickListener: ImageClickListener
) : RecyclerView.Adapter<MainGalleryAdapter.MainGalleryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainGalleryItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewHomeMainBinding.inflate(inflater, parent, false)
        return MainGalleryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainGalleryItemViewHolder, position: Int) {
        imageList?.let {
            if (it.isNotEmpty()) {
                holder.bindItems(it, imageClickListener, position)
            }
        }
    }

    override fun getItemCount(): Int = imageList?.size ?: 0

    inner class MainGalleryItemViewHolder(var binding: ItemViewHomeMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(
            images: Array<Image>,
            imageClickListener: ImageClickListener,
            position: Int
        ) {
            binding.rvItemHomeMain.setOnClickListener {
                imageClickListener.onClick(ImageData(images, position))
            }

//            loadImageListener.loadImages(images[position].url, binding.rvItemHomeMain)

            val appContext = (binding.rvItemHomeMain.context).applicationContext as ImageApp
            appContext.getGlideService(images[position].url, binding.rvItemHomeMain)

        }
    }
}