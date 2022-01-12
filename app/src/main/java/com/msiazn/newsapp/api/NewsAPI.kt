package com.msiazn.newsapp.api

import com.msiazn.newsapp.model.ResponseNews
import com.msiazn.newsapp.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode:String = "us",
        @Query("page")
        page:Int = 1,
        @Query("apiKey")
        apiKey:String = API_KEY

    ): Response<ResponseNews>


    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery:String,
        @Query("page")
        page:Int = 1,
        @Query("apiKey")
        apiKey:String = API_KEY

    ): Response<ResponseNews>

}