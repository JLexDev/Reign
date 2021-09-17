package com.jlexdev.data.di

import com.jlexdev.data.network.mapper.ReignDataMapper
import com.jlexdev.data.network.mapper.ReignDataMapperImpl
import org.koin.dsl.module

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

val mapperDataModule = module {
    single<ReignDataMapper>{ ReignDataMapperImpl() }
}