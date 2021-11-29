package com.merkost.redditlist.model.room

import com.merkost.redditlist.model.room.entities.Post
import com.merkost.redditlist.model.room.entities.WelcomeRoom
import kotlinx.coroutines.flow.Flow

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getPosts(): Flow<WelcomeRoom> = appDatabase.welcomeDao().getPosts()

    //override suspend fun getPostsByTime(): List<Post> = appDatabase.welcomeDao().getPostsByDate()

    //override suspend fun getPostsByScore(): List<Post> = appDatabase.welcomeDao().getPostsByVotes()

    //override suspend fun insertAll(posts: List<Post>) = appDatabase.welcomeDao().insertAllPosts(posts)

    override suspend fun insertPosts(post: WelcomeRoom) = appDatabase.welcomeDao().insertPosts(post)

}