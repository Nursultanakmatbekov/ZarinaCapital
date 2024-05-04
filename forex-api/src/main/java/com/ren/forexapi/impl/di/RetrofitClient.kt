package com.ren.forexapi.impl.di

import com.ren.forexapi.api.service.auth.AuthApiService
import com.ren.forexapi.api.service.courses.CoursesApiService
import com.ren.forexapi.api.service.news.NewsApiService
import com.ren.forexapi.api.service.raviews.ReviewsApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

internal class RetrofitClient(
    private val baseUrl: String
) {

    private val httpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(
            HttpLoggingInterceptor.Level.BODY
        )

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            httpLoggingInterceptor
        )
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val authApiService: AuthApiService = retrofit.create()

    val newsApiService: NewsApiService = retrofit.create()

    val coursesApiService: CoursesApiService = retrofit.create()

    val reviewsApiService: ReviewsApiService = retrofit.create()
}
