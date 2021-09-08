package com.nytimesapp.samp.network

import com.nytimesapp.samp.responsemodels.LatestArticlesResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/viewed/7.json")
    suspend fun getPost(
        @Query("api-key") apiKey: String
    ): LatestArticlesResponseModel

}