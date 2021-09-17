package com.jlexdev.domain.repository

import com.jlexdev.domain.entity.Either
import com.jlexdev.domain.entity.Failure
import com.jlexdev.domain.entity.ReignEntity

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

interface ReignRepository {

    suspend fun getHits(query: String) : Either<Failure, ReignEntity>
}