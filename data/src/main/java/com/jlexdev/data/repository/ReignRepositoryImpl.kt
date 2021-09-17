package com.jlexdev.data.repository

import com.jlexdev.data.network.endpoints.EndPoints
import com.jlexdev.data.network.mapper.ReignDataMapper
import com.jlexdev.domain.entity.Either
import com.jlexdev.domain.entity.Failure
import com.jlexdev.domain.entity.ReignEntity
import com.jlexdev.domain.repository.ReignRepository

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

class ReignRepositoryImpl(private val service: EndPoints,
                          private val mapper: ReignDataMapper) : ReignRepository {

    override suspend fun getHits(query: String): Either<Failure, ReignEntity> {
        return when(val response = service.getHits(query)){
            is Either.Right -> Either.Right(mapper.hitsDataToDomain(response.b))
            is Either.Left -> Either.Left(response.a)
        }
    }
}