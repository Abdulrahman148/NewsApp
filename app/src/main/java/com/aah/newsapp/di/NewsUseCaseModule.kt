package com.aah.newsapp.di

import com.example.domain.repo.NewsRepository
import com.example.domain.usecase.NewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsUseCaseModule {

    @Provides
    @Singleton
    fun provideNewsUseCase(newsRepository: NewsRepository): NewsUseCase {
        return NewsUseCase(newsRepository)
    }

}