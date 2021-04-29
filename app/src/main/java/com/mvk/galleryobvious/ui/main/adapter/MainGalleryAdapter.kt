package com.mvk.galleryobvious.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvk.galleryobvious.ImageApp
import com.mvk.galleryobvious.data.model.Image
import com.mvk.galleryobvious.data.model.ImageData
import com.mvk.galleryobvious.databinding.ItemViewHomeMainBinding
import com.mvk.galleryobvious.ui.main.utils.ImageClickListener

/**
 * Recycler view adapter for the main screen listing.
 *
 * @param imageList List of images to display in the activity
 * @param imageClickListener Listener to handle clicks of the images
 */
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

    /**
     * View holder to display the images
     *
     * @param binding Binding with the layout file (item_view_home_main.xml) to access it's elements
     */
    inner class MainGalleryItemViewHolder(var binding: ItemViewHomeMainBinding) :
            RecyclerView.ViewHolder(binding.root) {

        /**
         * Loads the images through Glide and handles click of each item
         *
         * @param images List of images to show
         * @param imageClickListener Listener to handle clicks on each button
         * @param position Position of the current loading image
         */
        fun bindItems(
                images: Array<Image>,
                imageClickListener: ImageClickListener,
                position: Int
        ) {
            // Call Glide service
            val appContext = (binding.rvItemHomeMain.context).applicationContext as ImageApp
            appContext.getGlideService(url = images[position].url, targetIV = binding.rvItemHomeMain)

            // Set click listener
            binding.rvItemHomeMain.setOnClickListener {
                imageClickListener.onClick(ImageData(images, position))
            }
        }
    }
}