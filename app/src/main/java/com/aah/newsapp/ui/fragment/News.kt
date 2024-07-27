package com.aah.newsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import com.aah.newsapp.databinding.FragmentNewsBinding
import com.aah.newsapp.ui.adapter.NewsAdapter
import com.aah.newsapp.ui.adapter.NewsPagedAdapter
import com.aah.newsapp.ui.components.LoadingDialog
import com.aah.newsapp.ui.viewModel.NewsViewModel
import com.example.domain.model.Articles
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class News : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private val newsViewModel: NewsViewModel by viewModels()
    private val mAdapter by lazy { NewsAdapter() }
    private val loadingDialog: LoadingDialog by lazy { LoadingDialog(this) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            loadingDialog.showDialog()
            delay(2000)
            loadingDialog.hideDialog()
        }

        newsViewModel.getData()
        initViews()
        observe()

    }


    private fun initViews() {
        binding.newsRecyclerview.adapter = mAdapter
        binding.newsRecyclerview.setHasFixedSize(true)
    }

    private fun observe() {
        lifecycleScope.launch {
            newsViewModel._newsList.collect {
                try {
                    Log.d("nageh", "observe: $it")
                    mAdapter.addData(it.toMutableList())
                } catch (e: Exception) {
                    Log.d("newsListObserver", e.message.toString())
                }

            }
        }
    }
}