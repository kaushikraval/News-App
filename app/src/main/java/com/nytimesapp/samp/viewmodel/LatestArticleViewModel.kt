package com.nytimesapp.samp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nytimesapp.samp.repository.LatestArticleRepository
import com.nytimesapp.samp.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
    this view model will be responsible to handle to data from api call via repository and using stateflow
    it will emit data to LatestArticle fragment whenever new data avialble
 */
@HiltViewModel
class LatestArticleViewModel
@Inject
constructor(private val latestArticleRepository: LatestArticleRepository) : ViewModel() {

    // empty mutable state flow
    private val postStateFlow: MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)

    val _latestArticleResponseFlow: StateFlow<ApiState> = postStateFlow

    /*
        this function will collect new data from repository and provide it to fragment to show in UI
        in case of failure it will emit error message
     */

    fun getPost() = viewModelScope.launch {
        postStateFlow.value = ApiState.Loading
        latestArticleRepository.getPost()
            .catch { e ->
                postStateFlow.value = ApiState.Failure(e)
            }.collect { data ->
                postStateFlow.value = ApiState.Success(data)
            }
    }
}