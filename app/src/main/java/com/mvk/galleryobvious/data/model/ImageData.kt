package com.mvk.galleryobvious.data.model

import java.io.Serializable

/**
 * Model for that holds the list of NASA images with current image position
 *
 * @param image List of images
 * @param position Current image position
 */
data class ImageData(var image: Array<Image>, var position: Int) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ImageData

        if (!image.contentEquals(other.image)) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = image.contentHashCode()
        result = 31 * result + position
        return result
    }
}