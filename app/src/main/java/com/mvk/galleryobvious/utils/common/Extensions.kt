/*
 * Created by Manpreet Kunnath on 29/1/2020 10:16
 * Copyright (c) 2020 . All rights reserved.
 */

package com.mvk.galleryobvious.utils.common

import java.io.InputStream
import java.nio.charset.Charset

/**
 * Read input from a file
 *
 * @param charset InputStream
 * @return Read string
 */
fun InputStream.readInput(charset: Charset = Charsets.UTF_8): String {
    return this.bufferedReader(charset).use { it.readText() }
}
