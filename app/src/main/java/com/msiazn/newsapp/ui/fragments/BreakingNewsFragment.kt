package com.msiazn.newsapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.msiazn.newsapp.R
import com.msiazn.newsapp.adapter.NewsAdapter
import com.msiazn.newsapp.databinding.FragmentBreakingNewsBinding
import com.msiazn.newsapp.ui.NewsActivity
import com.msiazn.newsapp.util.Resource
import com.msiazn.newsapp.viewmodel.NewsViewModel

class BreakingNewsFragment:Fragment(R.layout.fragment_breaking_news) {
    lateinit var viewModel:NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var binding:FragmentBreakingNewsBinding



    val TAG = "BreakingNewsFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBreakingNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        setupRecyclerView()

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer {response ->
            when(response){
                is Resource.Success->{
                    hideProgressBar()
                    response.data?.let { newsResponse->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error->{
                    hideProgressBar()
                    response.message?.let { errorMessage->
                    Log.d(TAG, "An Error Occured $errorMessage")
                    }
                }
                is Resource.Loading->{
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        binding.paginationProgressBar.visibility = View.INVISIBLE
    }
    private fun showProgressBar() {
        binding.paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView(){
        newsAdapter = NewsAdapter()
        binding.rvBreakingNews.apply {
            this.adapter = newsAdapter
            this.layoutManager = LinearLayoutManager(activity)
        }
    }

}