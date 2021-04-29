package com.mvk.galleryobvious.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvk.galleryobvious.ImageApp
import com.mvk.galleryobvious.R
import com.mvk.galleryobvious.data.model.ImageData
import com.mvk.galleryobvious.databinding.ItemViewDetailBinding
import com.mvk.galleryobvious.ui.detail.utils.FullScreenClickListener

class DetailViewAdapter(
    var imageData: ImageData,
    var fullScreenClickListener: FullScreenClickListener
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

    inner class DetailViewHolder(var binding: ItemViewDetailBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindItems(
            imageData: ImageData,
            viewPagerPosition: Int,
            fullScreenClickListener: FullScreenClickListener
        ) {
            val appContext = (binding.detailFullScreenIV.context).applicationContext as ImageApp
            appContext.getGlideService(
                url = imageData.image[viewPagerPosition].url,
                targetIV = binding.detailMainIV, binding.detailFullScreenIV
            )

            binding.detailTitleTV.text = imageData.image[viewPagerPosition].title
            val copyright = String.format(
                binding.detailCopyrightTV.context.resources.getString(R.string.detail_text_copyright),
                imageData.image[viewPagerPosition].copyright
            )
            binding.detailCopyrightTV.text = copyright
            binding.detailExplanationTV.text = imageData.image[viewPagerPosition].explanation
            binding.detailDateTV.text = imageData.image[viewPagerPosition].date

            binding.detailFullScreenIV.setOnClickListener {
                fullScreenClickListener.onClick(viewPagerPosition, binding.detailFullScreenIV)
            }
        }
    }
}