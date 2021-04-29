package com.mvk.galleryobvious.data.remote

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.mvk.galleryobvious.R
import com.mvk.galleryobvious.ui.main.utils.LoadImagesService
import com.mvk.galleryobvious.utils.common.Constants

/**
 * Implements [LoadImagesService] and uses Glide library to load requested images.
 */
object LoadImagesServiceImpl : LoadImagesService {

    /**
     * Load images from Glide
     *
     * @param url URL of the image to load
     * @param targetIV Image view to load the downloaded image
     * @param fullScreenIV Full screen image view reference to be enabled when image has been downloaded
     * @param source App screen ID
     */
    override fun loadImages(url: String, targetIV: ImageView, fullScreenIV: ImageView?, source: Int) {
        // Crop based on the screen
        val crop =
                if (source == Constants.SOURCE_FULL_SCREEN) FitCenter()
                else CenterCrop()
        // Init Glide and load image
        Glide.with(targetIV.context)
                .load(url)
                .transform(crop)
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_error)
                .listener(object : RequestListener<Drawable> {
                    // If image loading fails show the error
                    override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>?,
                            isFirstResource: Boolean
                    ): Boolean {
                        // Error message when image loading fails
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
                        // Show full screen button after the image has been loaded
                        fullScreenIV?.let {
                            it.visibility = View.VISIBLE
                        }
                        return false
                    }

                })
                .into(targetIV)
    }
}