package com.nytimesapp.samp.repository

import com.nytimesapp.samp.network.ApiServiceImpl
import com.nytimesapp.samp.responsemodels.LatestArticlesResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

class LatestArticleRepository
@Inject
constructor(private val apiServiceImpl: ApiServiceImpl) {

    fun getPost(): Flow<LatestArticlesResponseModel> = flow {
        emit(apiServiceImpl.getPost())
    }.flowOn(Dispatchers.IO)

}