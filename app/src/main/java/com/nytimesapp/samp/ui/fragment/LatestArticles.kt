package com.nytimesapp.samp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nytimesapp.samp.R
import com.nytimesapp.samp.adapter.ArticleListAdapter
import com.nytimesapp.samp.databinding.FragmentLatestArticleBinding
import com.nytimesapp.samp.listeners.ArticleClickListener
import com.nytimesapp.samp.responsemodels.Result
import com.nytimesapp.samp.util.ApiState
import com.nytimesapp.samp.util.toast
import com.nytimesapp.samp.viewmodel.LatestArticleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LatestArticles : Fragment(R.layout.fragment_latest_article), ArticleClickListener {

    private var _binding: FragmentLatestArticleBinding? = null
    private val binding get() = _binding!!
    private lateinit var articleListAdapter: ArticleListAdapter
    private val latestArticleViewModel: LatestArticleViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLatestArticleBinding.bind(view)

        initRecyclerview()
        getLatestArticles()

    }

    private fun getLatestArticles() {
        // api call to get latest articles
        latestArticleViewModel.getPost()
        lifecycleScope.launchWhenStarted {
            latestArticleViewModel._latestArticleResponseFlow.collect {
                when (it) {
                    is ApiState.Loading -> {
                        binding.articlesListRv.isVisible = false
                        binding.progressBar.isVisible = true
                    }
                    is ApiState.Failure -> {
                        binding.articlesListRv.isVisible = false
                        binding.progressBar.isVisible = false
                        activity?.toast(getString(R.string.api_error_messge))
                    }
                    // show article list in case of success
                    is ApiState.Success -> {
                        binding.articlesListRv.isVisible = true
                        binding.progressBar.isVisible = false
                        articleListAdapter.setData(it.articleResponse.results!!)
                        articleListAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

    // initialize recyclerview
    private fun initRecyclerview() {
        articleListAdapter = ArticleListAdapter(this)
        binding.articlesListRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = articleListAdapter
        }
    }

    // clear all the views on fragment destroy
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    // move to detail screen when user clicks on single item using nav args
    override fun onArticleClick(articleData: Result) {
        val action = LatestArticlesDirections.actionLatestArticlesToLatestArticleDetails(articleData)
        findNavController().navigate(action)
    }

}