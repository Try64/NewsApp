package com.msiazn.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.msiazn.newsapp.R
import com.msiazn.newsapp.ui.NewsActivity
import com.msiazn.newsapp.viewmodel.NewsViewModel

class ArticleFragment:Fragment(R.layout.fragment_article) {
    lateinit var viewModel:NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }

}