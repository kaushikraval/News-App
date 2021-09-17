package com.nytimesapp.samp.repository

import com.nytimesapp.samp.network.ApiServiceImpl
import com.nytimesapp.samp.responsemodels.LatestArticlesResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LatestArticleRepository
@Inject
constructor(private val apiServiceImpl: ApiServiceImpl) {

    /*
    make api call to get popular articles and here flow will emit latest article whenever new data
    available
     */
    fun getPost(): Flow<LatestArticlesResponseModel> = flow {
        emit(apiServiceImpl.getPost())
    }.flowOn(Dispatchers.IO)

}