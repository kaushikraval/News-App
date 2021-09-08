package com.nytimesapp.samp.util

import com.nytimesapp.samp.responsemodels.LatestArticlesResponseModel

sealed class ApiState {
    object Loading : ApiState()
    class Failure(val message: Throwable) : ApiState()
    class Success(val articleResponse: LatestArticlesResponseModel) : ApiState()
    object Empty : ApiState()
}
