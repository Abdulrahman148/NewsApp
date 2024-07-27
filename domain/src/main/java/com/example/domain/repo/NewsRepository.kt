package com.example.domain.repo


import androidx.paging.PagingData
import com.example.domain.model.Articles
import com.example.domain.model.NewsModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NewsRepository {
    suspend fun getAllNews() : Response<NewsModel>
    //fun getPagedNews() : Flow<PagingData<Articles>>
}