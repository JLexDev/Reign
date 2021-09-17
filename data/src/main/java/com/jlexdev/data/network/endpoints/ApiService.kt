package com.jlexdev.data.network.endpoints

import com.jlexdev.data.network.response.ReignResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

interface ApiService {

    @GET("api/v1/search_by_date") //?query={mobile}
    suspend fun getHits(@Query("query") query: String) : Response<ReignResponse>
}