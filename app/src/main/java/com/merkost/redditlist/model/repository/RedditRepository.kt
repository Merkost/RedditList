package com.merkost.redditlist.model.repository

import com.merkost.redditlist.model.entity.ChildData
import com.merkost.redditlist.model.entity.Children
import kotlinx.coroutines.flow.Flow

interface RedditRepository {
    suspend fun getHotPosts(): Flow<List<Children>>
}