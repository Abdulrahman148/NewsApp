package com.example.data.repoImplementation

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData

import com.example.data.remote.NewsInterface
import com.example.domain.model.Articles
import com.example.domain.model.NewsModel

import com.example.domain.repo.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class RepositoryImpl(private val newsInterface: NewsInterface): NewsRepository {
    override suspend fun getAllNews(): Response<NewsModel> {
        return newsInterface.getNews()
    }

    /*override fun getPagedNews(): Flow<PagingData<Articles>> {
        return Pager(
            config = PagingConfig(pageSize = 5, enablePlaceholders = false),
            pagingSourceFactory = { NewsPagingSource(newsInterface) }
        ).flow
    }*/
}