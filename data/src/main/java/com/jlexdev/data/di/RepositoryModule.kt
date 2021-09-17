package com.jlexdev.data.di

import com.jlexdev.data.repository.ReignRepositoryImpl
import com.jlexdev.domain.repository.ReignRepository
import org.koin.dsl.module

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

val repositoryModule = module {
    single<ReignRepository> { ReignRepositoryImpl(get(), get()) }
}