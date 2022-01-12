package com.msiazn.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.msiazn.newsapp.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
):ViewModel() {
}