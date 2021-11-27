package com.merkost.redditlist.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merkost.redditlist.model.entity.ChildData
import com.merkost.redditlist.model.entity.Children
import com.merkost.redditlist.model.repository.RedditRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(private val repository: RedditRepository): ViewModel() {

    val currentContent = MutableStateFlow<List<Children>>(listOf())

    init {
        getTop250Movies()
    }

    private fun getTop250Movies() {
        viewModelScope.launch {
            repository.getHotPosts().collect {
                if (it.isNotEmpty())
                    currentContent.value = it
            }
        }
    }

}
