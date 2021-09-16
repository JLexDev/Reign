package com.jlexdev.data.di

import com.jlexdev.data.BuildConfig
import com.jlexdev.data.network.endpoints.ApiService
import com.jlexdev.data.network.endpoints.EndPoints
import com.jlexdev.data.network.endpoints.EndPointsImpl
import com.jlexdev.data.network.utils.NetworkUtils
import com.jlexdev.data.network.utils.NetworkUtilsImpl
import com.jlexdev.data.network.utils.SupportInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

val networkModule = module {
    single<NetworkUtils> { NetworkUtilsImpl(androidContext()) }
    factory { SupportInterceptor(get()) }
    single { provideOkHttpClient(get()) }
    single { provideApi(get()) }
    single { provideRetrofit(get()) }
    single<EndPoints> { EndPointsImpl(get(), get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

fun provideOkHttpClient(authInterceptor: SupportInterceptor): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    val builder = OkHttpClient.Builder()
    builder.addInterceptor(interceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(authInterceptor)
    return builder.build()
}

fun provideApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
