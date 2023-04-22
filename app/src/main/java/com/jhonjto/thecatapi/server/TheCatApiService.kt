package com.jhonjto.thecatapi.server

import com.jhonjto.thecatapi.server.response.CatsListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCatApiService {
    @GET("breeds")
    suspend fun getListCats(
        @Query("api_key") apiKey: String
    ): CatsListResponse
}