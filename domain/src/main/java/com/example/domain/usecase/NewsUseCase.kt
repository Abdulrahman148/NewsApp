package com.example.domain.usecase

import com.example.domain.model.NewsModel
import com.example.domain.repo.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsUseCase(private val newsRepository: NewsRepository) {
    suspend operator fun invoke() = newsRepository.getAllNews()
}

/*
class PagedNewsUseCase(private val newsRepository: NewsRepository) {
    operator fun invoke() = newsRepository.getPagedNews()
}*/
