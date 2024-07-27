package com.example.data.remote

import android.util.Log
import com.example.domain.model.NewsModel
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

interface NewsInterface {

    @GET("/v2/everything?q=tesla&from=2024-06-27&sortBy=publishedAt&apiKey=65a6a770b95c41a689a2a5dea9e07536")
    suspend fun getNews(): Response<NewsModel>
}