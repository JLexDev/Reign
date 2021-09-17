package com.jlexdev.data.network.mapper

import com.jlexdev.data.network.response.ReignResponse
import com.jlexdev.domain.entity.HitsEntity
import com.jlexdev.domain.entity.ReignEntity

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

class ReignDataMapperImpl : ReignDataMapper {

    override suspend fun hitsDataToDomain(reign: ReignResponse): ReignEntity {
        return ReignEntity(
            reign.hits.map { HitsEntity(it.createdAt, it.title, it.author, it.storyTitle) },
            reign.query
        )
    }
}