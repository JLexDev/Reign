package com.jlexdev.reign.mapper

import com.jlexdev.domain.entity.ReignEntity
import com.jlexdev.reign.model.ReignModel

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

interface ReignMapper {

    suspend fun hitsDomainToApp(reign: ReignEntity) : ReignModel
}