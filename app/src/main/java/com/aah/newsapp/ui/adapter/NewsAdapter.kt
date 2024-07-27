package com.aah.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aah.newsapp.R
import com.aah.newsapp.databinding.NewsListItemBinding
import com.bumptech.glide.Glide
import com.example.domain.model.Articles

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val dataSet: MutableList<Articles> = mutableListOf()

    fun addData(items: MutableList<Articles>) {
        dataSet.addAll(items)
        notifyDataSetChanged()
    }

    class NewsViewHolder(binding: NewsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.articleTitle
        //val author = binding.articleAuthor
        //val publishedAt = binding.articlePublishedAt
        val img = binding.articleImg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsList = dataSet[position]
        holder.title.text = newsList.title
        //holder.author.text = newsList.author
        //holder.publishedAt.text = newsList.publishedAt

        val imageUrl = newsList.urlToImage


        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.img)

    }

    override fun getItemCount() = dataSet.size
}