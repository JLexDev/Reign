package com.jlexdev.data.network.response

import com.google.gson.annotations.SerializedName

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

data class HitsResponse (
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("title") val title: String?,
    @SerializedName("author") val author: String,
    @SerializedName("story_title") val storyTitle: String?
)