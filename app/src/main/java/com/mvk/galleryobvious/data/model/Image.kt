package com.mvk.galleryobvious.data.model

import com.google.gson.annotations.SerializedName

/**
 * Model for the NASA images
 */
class Image(

    @SerializedName("copyright")
    val copyright: String,

    @SerializedName("date")
    val date: String,

    @SerializedName("explanation")
    val explanation: String,

    @SerializedName("hdurl")
    val hdurl: String,

    @SerializedName("media_type")
    val mediaType: String,

    @SerializedName("serviceVersion")
    val serviceVersion: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String
)