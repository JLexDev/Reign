package com.jlexdev.data.network.response

import com.google.gson.annotations.SerializedName

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

data class ReignResponse (
    @SerializedName("hits") val hits: List<HitsResponse>,
    @SerializedName("query") val query: String
)