package com.jlexdev.reign.di

import com.jlexdev.reign.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

val viewModelModule = module {
    viewModel { MainViewModel(get(), get()) }
}