/*
package com.example.data.repoImplementation

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.remote.NewsInterface
import com.example.domain.model.Articles

private const val STARTING_PAGE_INDEX = 1

class NewsPagingSource(
    private val newsInterface: NewsInterface
) : PagingSource<Int, Articles>() {

    override fun getRefreshKey(state: PagingState<Int, Articles>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)

        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Articles> {

        return try {
            val currentPage = params.key ?: STARTING_PAGE_INDEX
            val response = newsInterface.getNews(currentPage)
            val data = response.body()?.articles ?: emptyList()

            val responseData = mutableListOf<Articles>()
            responseData.addAll(data)

            if (response.isSuccessful) {
                LoadResult.Page(
                    data = data,
                    prevKey = if (currentPage == STARTING_PAGE_INDEX) null else (currentPage - 1),
                    nextKey = if (responseData.isEmpty()) null else (currentPage + 1)
                )
            } else {
                LoadResult.Error(Throwable("Error Occurred"))
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

}*/
