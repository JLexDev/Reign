package com.jlexdev.reign.mapper

import com.jlexdev.domain.entity.ReignEntity
import com.jlexdev.reign.model.HitsModel
import com.jlexdev.reign.model.ReignModel

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

class ReignModelMapperImpl : ReignModelMapper {

    override suspend fun hitsDomainToApp(reign: ReignEntity): ReignModel {
        return ReignModel(
            hits = reign.hits.map { hits ->
                HitsModel(createdAt = hits.createdAt, title = hits.title, author = hits.author, storyTitle = hits.storyTitle)
            },
            query = reign.query
        )
    }

}