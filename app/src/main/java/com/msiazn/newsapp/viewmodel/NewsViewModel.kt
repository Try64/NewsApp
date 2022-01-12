package com.msiazn.newsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msiazn.newsapp.model.ResponseNews
import com.msiazn.newsapp.repository.NewsRepository
import com.msiazn.newsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository: NewsRepository
):ViewModel() {

    val breakingNews:MutableLiveData<Resource<ResponseNews>> = MutableLiveData()
    var breakingNewsPage = 1

    init {
        getBreakingNews("us")
    }

    fun getBreakingNews(countryCode:String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())

        val response = newsRepository.getBreakingNews(countryCode,breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(response: Response<ResponseNews>) : Resource<ResponseNews>{
        if(response.isSuccessful){
            response.body()?.let { resposeResult ->
                return Resource.Success(resposeResult)
            }
        }
        return Resource.Error(response.message())
    }


}