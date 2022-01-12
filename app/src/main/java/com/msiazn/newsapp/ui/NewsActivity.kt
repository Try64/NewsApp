package com.msiazn.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.msiazn.newsapp.R
import com.msiazn.newsapp.databinding.ActivityNewsBinding
import com.msiazn.newsapp.db.ArticleDatabase
import com.msiazn.newsapp.repository.NewsRepository
import com.msiazn.newsapp.viewmodel.NewsViewModel
import com.msiazn.newsapp.viewmodel.NewsViewModelFactory

class NewsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityNewsBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelFactory(newsRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)

        binding.bottomNavigationView.setupWithNavController((supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment).navController)


    }
}
