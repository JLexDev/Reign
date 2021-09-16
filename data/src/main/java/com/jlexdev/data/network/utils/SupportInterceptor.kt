package com.jlexdev.data.network.utils

import com.jlexdev.data.network.preferences.SecurePreferences
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

class SupportInterceptor(private val preferences : SecurePreferences) : Interceptor {

    /**
     * Interceptor class for setting of the headers for every request
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .addHeader("Authorization", preferences.getAccessToken())
            .build()
        return chain.proceed(request)
    }
}