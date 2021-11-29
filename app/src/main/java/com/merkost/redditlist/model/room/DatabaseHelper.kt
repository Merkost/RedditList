package com.merkost.redditlist.model.room

import com.merkost.redditlist.model.entity.Welcome1
import com.merkost.redditlist.model.room.entities.Post
import com.merkost.redditlist.model.room.entities.WelcomeRoom
import kotlinx.coroutines.flow.Flow

interface DatabaseHelper {

    suspend fun getPosts(): Flow<WelcomeRoom>
/*    suspend fun getPostsByTime(): List<Post>
    suspend fun getPostsByScore(): List<Post>*/

    //suspend fun insertAll(posts: List<WelcomeRoom>)
    suspend fun insertPosts(post: WelcomeRoom)

}