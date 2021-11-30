package com.merkost.redditlist.model.room

import com.merkost.redditlist.model.room.entities.Post
import com.merkost.redditlist.model.room.entities.WelcomeRoom
import kotlinx.coroutines.flow.Flow

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getPosts(): Flow<List<WelcomeRoom>> =
        appDatabase.welcomeRoomDao().getPosts()

    //override suspend fun getPostsByTime(): List<Post> = appDatabase.welcomeDao().getPostsByDate()

    //override suspend fun getPostsByScore(): List<Post> = appDatabase.welcomeDao().getPostsByVotes()

    override suspend fun insertAll(posts: List<WelcomeRoom>) =
        appDatabase.welcomeRoomDao().insertAllPosts(posts)

    override suspend fun insertPosts(post: WelcomeRoom) =
        appDatabase.welcomeRoomDao().insertPosts(post)

}