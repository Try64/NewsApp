package com.msiazn.newsapp.repository

import com.msiazn.newsapp.db.ArticleDatabase
import com.msiazn.newsapp.util.RetrofitInstance

class NewsRepository(
    val db:ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode:String,pageNumber:Int) = RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)
}