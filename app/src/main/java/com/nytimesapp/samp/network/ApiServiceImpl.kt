package com.nytimesapp.samp.network

import com.nytimesapp.samp.responsemodels.LatestArticlesResponseModel
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService) {

    // suspend function to make api call for most popular posts
    suspend fun getPost(): LatestArticlesResponseModel = apiService.getPost("9IetPyEaciFTdMGYZeIofLhdwlXB9ZSw")
}