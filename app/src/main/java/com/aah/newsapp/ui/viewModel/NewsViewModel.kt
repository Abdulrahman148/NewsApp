package com.aah.newsapp.ui.viewModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.domain.model.Articles
import com.example.domain.model.NewsModel
import com.example.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(/*val pagedNewsUseCase: PagedNewsUseCase,*/ val newsUseCase: NewsUseCase) : ViewModel() {

    private val newsList = MutableStateFlow(NewsModel())
    val _newsList = MutableStateFlow<List<Articles>>(listOf())

    //val news: Flow<PagingData<Articles>> = pagedNewsUseCase().cachedIn(viewModelScope)



    fun getData() {
        viewModelScope.launch {
            try {
                newsList.value.articles = newsUseCase().body()!!.articles
                _newsList.value = newsList.value.articles
            } catch (e: Exception) {
                Log.d("newsListViewModel", e.message.toString())
            }

        }
    }

}