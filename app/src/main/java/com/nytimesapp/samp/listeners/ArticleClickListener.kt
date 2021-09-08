package com.nytimesapp.samp.listeners

import com.nytimesapp.samp.responsemodels.Result

interface ArticleClickListener {
    fun onArticleClick(articleData: Result)
}