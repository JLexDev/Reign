package com.jlexdev.domain.usecase

import com.jlexdev.domain.entity.ReignEntity
import com.jlexdev.domain.repository.ReignRepository

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

class GetReignUseCase (private val reignRepository: ReignRepository) : BaseUseCase<ReignEntity, GetReignUseCase.Params>() {

    override suspend fun run(params: Params) = reignRepository.getHits(params.query)

    data class Params(val query: String)
}