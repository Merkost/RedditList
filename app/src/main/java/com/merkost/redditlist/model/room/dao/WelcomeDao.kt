package com.merkost.redditlist.model.room.dao

import androidx.room.*
import com.merkost.redditlist.model.room.entities.Post
import com.merkost.redditlist.model.room.entities.WelcomeRoom
import kotlinx.coroutines.flow.Flow

@Dao
interface WelcomeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPosts(posts: WelcomeRoom)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(post: WelcomeRoom)

    @Update
    suspend fun updatePost(post: WelcomeRoom)

    @Delete
    suspend fun deletePost(post: WelcomeRoom)

    /*@Query("SELECT * FROM Post ORDER BY created_utc")
    suspend fun getPostsByDate(): List<Post>

    @Query("SELECT * FROM Post ORDER BY score")
    suspend fun getPostsByVotes(): List<Post>*/

    @Query("SELECT * FROM Post")
    fun getPosts(): Flow<WelcomeRoom>
}