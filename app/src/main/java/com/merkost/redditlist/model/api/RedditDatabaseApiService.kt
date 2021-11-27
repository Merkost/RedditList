package com.merkost.redditlist.model.api

import com.merkost.redditlist.model.entity.Children
import com.merkost.redditlist.model.entity.Welcome1
import retrofit2.http.GET

interface RedditDatabaseApiService {

    @GET("r/aww/hot.json")
    suspend fun getHotPosts(): Welcome1

}

