package com.mvk.galleryobvious.data.remote

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.mvk.galleryobvious.R
import com.mvk.galleryobvious.ui.main.utils.LoadImagesService

object LoadImagesServiceImpl : LoadImagesService {

    override fun loadImages(url: String, targetIV: ImageView, sourceType: Int) {
        Glide.with(targetIV.context)
            .load(url)
            .transform(CenterCrop())
//            .placeholder(placeholderImage)
//            .error(errorImage)
            .listener(object : RequestListener<Drawable> {
                // If image loading fails show the error
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    val errorMessage = targetIV.context.getString(R.string.home_error_image_loading)
                    Toast.makeText(targetIV.context, errorMessage, Toast.LENGTH_LONG).show()
                    return false
                }

                // When the image is loaded show the full screen icon
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

            })
            .into(targetIV)
    }
}