package com.aah.newsapp.di

import com.example.data.remote.NewsInterface
import com.example.data.repoImplementation.RepositoryImpl
import com.example.domain.repo.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(newsInterface: NewsInterface): NewsRepository {
        return RepositoryImpl(newsInterface)
    }


}