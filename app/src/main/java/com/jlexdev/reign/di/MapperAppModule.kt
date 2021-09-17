package com.jlexdev.reign.di

import com.jlexdev.reign.mapper.ReignModelMapper
import com.jlexdev.reign.mapper.ReignModelMapperImpl
import org.koin.dsl.module

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

val mapperAppModule = module {
    single<ReignModelMapper>{ ReignModelMapperImpl() }
}