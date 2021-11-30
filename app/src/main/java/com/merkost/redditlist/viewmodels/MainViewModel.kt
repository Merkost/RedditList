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
import com.merkost.redditlist.model.room.DatabaseHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel(
    private val repository: RedditRepository,
    private val dbHelper: DatabaseHelper
) : ViewModel() {

    val currentContent = MutableStateFlow<List<Children>>(listOf())

    val children: Flow<PagingData<Children>> = Pager(PagingConfig(pageSize = 10)) {
        WelcomeDataSource(repository, dbHelper)
    }.flow.cachedIn(viewModelScope)

    /*init {
        getRedditSavedPosts()
    }

    private fun getRedditSavedPosts() {
        viewModelScope.launch {
            dbHelper.getPosts().collect {
                if (it.isNotEmpty())
                    currentContent.value = it
            }
        }
    }*/

}
