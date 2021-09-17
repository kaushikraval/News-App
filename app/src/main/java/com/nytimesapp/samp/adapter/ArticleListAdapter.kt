package com.nytimesapp.samp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nytimesapp.samp.databinding.RowSingleArticleBinding
import com.nytimesapp.samp.listeners.ArticleClickListener
import com.nytimesapp.samp.responsemodels.Result

/*
    article list adapter to set data from response to adapter
    @param clickListener listens to single recyclerview item callback
 */
class ArticleListAdapter(
    private var clickListener: ArticleClickListener
) :
    RecyclerView.Adapter<ArticleListAdapter.PostViewHolder>() {

    private lateinit var binding: RowSingleArticleBinding
    private var articleList: ArrayList<Result> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding = RowSingleArticleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return PostViewHolder(binding.root)
    }


    // @param articleData -> single article data
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val articleData = articleList[position]
        binding.apply {
            tvItemOriginal.text = articleData.title
            tvItemDate.text = articleData.publishedDate
            tvItemExplain.text = articleData.byline
            tvItemTranslate.text = articleData.type
            rootSingleArticleLayout.setOnClickListener {
                clickListener.onArticleClick(articleData)
            }
        }
    }

    // total number of article
    override fun getItemCount(): Int = articleList.size

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    // @param articleList sets the latest list of article to recyclerview
    fun setData(articleList: ArrayList<Result>) {
        this.articleList = articleList
        notifyDataSetChanged()
    }

}