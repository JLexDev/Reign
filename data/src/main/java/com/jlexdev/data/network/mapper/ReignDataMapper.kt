package com.jlexdev.data.network.mapper

import com.jlexdev.data.network.response.ReignResponse
import com.jlexdev.domain.entity.ReignEntity

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

interface ReignDataMapper {

    suspend fun hitsDataToDomain(reign: ReignResponse) : ReignEntity
}