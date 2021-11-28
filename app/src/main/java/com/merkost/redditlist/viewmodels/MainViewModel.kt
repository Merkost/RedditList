package com.merkost.redditlist.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.merkost.redditlist.model.datasource.WelcomeDataSource
import com.merkost.redditlist.model.entity.Children
import com.merkost.redditlist.model.repository.RedditRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(private val repository: RedditRepository): ViewModel() {

    val currentContent = MutableStateFlow<List<Children>>(listOf())

    val children: Flow<PagingData<Children>> = Pager(PagingConfig(pageSize = 10)) {
        WelcomeDataSource(repository)
    }.flow.cachedIn(viewModelScope)

    /*init {
        getRedditPosts()
    }

    private fun getRedditPosts() {
        viewModelScope.launch {
            repository.getHotPosts().collect {
                if (it.isNotEmpty())
                    currentContent.value = it
            }
        }
    }*/

}
