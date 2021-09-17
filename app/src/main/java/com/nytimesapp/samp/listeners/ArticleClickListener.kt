package com.nytimesapp.samp.listeners

import com.nytimesapp.samp.responsemodels.Result

// click listener for single recyclerview item click
interface ArticleClickListener {
    fun onArticleClick(articleData: Result)
}