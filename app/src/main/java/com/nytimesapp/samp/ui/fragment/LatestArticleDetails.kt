package com.nytimesapp.samp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.nytimesapp.samp.R
import com.nytimesapp.samp.databinding.FragmentLatestArticleDetailsBinding

class LatestArticleDetails : Fragment(R.layout.fragment_latest_article_details) {

    private var _binding: FragmentLatestArticleDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: LatestArticleDetailsArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLatestArticleDetailsBinding.bind(view)

        setupImage()
        setupArticleData()

    }

    private fun setupImage() {
        args.articleData.media?.apply {
            this[0].mediaMetadata.apply {
                Glide.with(requireActivity())
                    .load(this!![2].url)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(binding.articleImage)
            }
        }
    }

    private fun setupArticleData() {
        val articleData = args.articleData
        binding.articleTitle.text = articleData.title
        binding.publishDate.text = getString(R.string.published_on) + articleData.publishedDate
        binding.publishedBy.text = articleData.byline
        binding.articleDetail.text = articleData.abstract
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}