package com.jlexdev.reign

import android.app.Application
import com.jlexdev.data.di.mapperDataModule
import com.jlexdev.data.di.networkModule
import com.jlexdev.data.di.preferencesModule
import com.jlexdev.data.di.repositoryModule
import com.jlexdev.domain.di.useCaseModule
import com.jlexdev.reign.di.mapperAppModule
import com.jlexdev.reign.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

class ReignApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ReignApplication)
            modules(arrayListOf(
                mapperAppModule, viewModelModule,
                mapperDataModule, networkModule, preferencesModule, repositoryModule,
                useCaseModule
            ))
        }
    }
}