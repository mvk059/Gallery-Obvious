package com.mvk.galleryobvious.data.datasource

import android.content.Context
import android.widget.Toast
import com.google.gson.GsonBuilder
import com.mvk.galleryobvious.R
import com.mvk.galleryobvious.data.model.Image
import com.mvk.galleryobvious.utils.common.Constants
import com.mvk.galleryobvious.utils.common.readInput
import java.io.IOException

/**
 * Class to fetch the image data
 *
 * @param context Context
 */
class ImageDataSource(private var context: Context) {

    /**
     * Fetches the JSON file from the assets directory and maps it to the model
     *
     * @return Image model
     */
    fun getImageData(): Array<Image>? {
        var json: String? = ""
        try {
            val inputStream = context.assets.open(Constants.IMAGE_ASSET_FILE_NAME)
            json = inputStream.readInput()
        } catch (e: IOException) {
            Toast.makeText(context, context.getString(R.string.error_text_file_not_found), Toast.LENGTH_SHORT).show()
        }
        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.create()
        return gson.fromJson(json, Array<Image>::class.java)
    }
}