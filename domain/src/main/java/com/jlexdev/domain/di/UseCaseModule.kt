package com.jlexdev.domain.di

import com.jlexdev.domain.usecase.GetReignUseCase
import org.koin.dsl.module

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

val useCaseModule = module {
    factory { GetReignUseCase(get()) }
}