package com.jlexdev.reign.di

import com.jlexdev.reign.mapper.ReignMapper
import com.jlexdev.reign.mapper.ReignMapperImpl
import org.koin.dsl.module

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

val mapperAppModule = module {
    single<ReignMapper>{ ReignMapperImpl() }
}