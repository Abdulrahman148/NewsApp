package com.aah.newsapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aah.newsapp.R
import com.aah.newsapp.databinding.NewsListItemBinding
import com.bumptech.glide.Glide
import com.example.domain.model.Articles

class NewsPagedAdapter : PagingDataAdapter<Articles, NewsPagedAdapter.NewsPagerViewHolder>(diffCallback) {

    inner class NewsPagerViewHolder(val binding: NewsListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Articles>() {
            override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
                return true
            }
        }
    }

    override fun onBindViewHolder(holder: NewsPagerViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.apply {
            articleTitle.text = currentItem?.title
            val imageUrl = currentItem?.urlToImage
            Glide.with(holder.itemView.context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(articleImg)
        }
        Log.d("TAGG", "onBindViewHolder: $currentItem")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsPagerViewHolder {
        return NewsPagerViewHolder(
            NewsListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }
}