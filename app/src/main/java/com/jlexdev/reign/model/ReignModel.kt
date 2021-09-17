package com.jlexdev.reign.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

@Parcelize
data class ReignModel (val hits: List<HitsModel>,
                       val query: String) : Parcelable