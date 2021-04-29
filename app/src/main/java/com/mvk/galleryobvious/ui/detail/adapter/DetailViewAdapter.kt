package com.mvk.galleryobvious.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvk.galleryobvious.ImageApp
import com.mvk.galleryobvious.R
import com.mvk.galleryobvious.data.model.ImageData
import com.mvk.galleryobvious.databinding.ItemViewDetailBinding
import com.mvk.galleryobvious.ui.detail.utils.FullScreenClickListener

/**
 * Recycler view adapter for the detail screen.
 *
 * @param imageData List of images
 * @param fullScreenClickListener Listener to handle full screen button click
 */
class DetailViewAdapter(
        private var imageData: ImageData,
        private var fullScreenClickListener: FullScreenClickListener
) : RecyclerView.Adapter<DetailViewAdapter.DetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewDetailBinding.inflate(inflater, parent, false)
        return DetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bindItems(imageData, position, fullScreenClickListener)
    }

    override fun getItemCount(): Int = imageData.image.size

    /**
     * View holder to display the images
     *
     * @param binding Binding with the layout file (detail_view_item.xml) to access it's elements
     */
    inner class DetailViewHolder(var binding: ItemViewDetailBinding) : RecyclerView.ViewHolder(binding.root) {

        /**
         * Sets all the required information in their respective fields
         *
         * @param imageData List of images
         * @param viewPagerPosition Position of the current item in the view pager
         * @param fullScreenClickListener Listener to handle full screen button click
         */
        fun bindItems(
                imageData: ImageData,
                viewPagerPosition: Int,
                fullScreenClickListener: FullScreenClickListener
        ) {
            // Call Glide service
            ImageApp.imageService.loadImages(
                    url = imageData.image[viewPagerPosition].url,
                    targetIV = binding.detailMainIV, binding.detailFullScreenIV
            )

            // Set data in the screen
            val copyright = String.format(
                    binding.detailCopyrightTV.context.resources.getString(R.string.detail_text_copyright),
                    imageData.image[viewPagerPosition].copyright
            )
            binding.detailCopyrightTV.text = copyright
            binding.detailTitleTV.text = imageData.image[viewPagerPosition].title
            binding.detailExplanationTV.text = imageData.image[viewPagerPosition].explanation
            binding.detailDateTV.text = imageData.image[viewPagerPosition].date

            // Click listener for full screen button
            binding.detailFullScreenIV.setOnClickListener {
                fullScreenClickListener.onClick(viewPagerPosition)
            }
        }
    }
}