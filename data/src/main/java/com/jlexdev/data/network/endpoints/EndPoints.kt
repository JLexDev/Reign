package com.jlexdev.data.network.endpoints

import com.jlexdev.data.network.response.ReignResponse
import com.jlexdev.domain.entity.Either
import com.jlexdev.domain.entity.Failure

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

interface EndPoints {

    suspend fun getHits(query: String) : Either<Failure, ReignResponse>
}