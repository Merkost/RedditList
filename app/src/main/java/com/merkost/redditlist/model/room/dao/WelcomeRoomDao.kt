package com.merkost.redditlist.model.room.dao

import androidx.room.*
import com.merkost.redditlist.model.room.entities.Post
import com.merkost.redditlist.model.room.entities.WelcomeRoom
import kotlinx.coroutines.flow.Flow

@Dao
interface WelcomeRoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPosts(data: List<WelcomeRoom>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(data: WelcomeRoom)

    @Update
    suspend fun updatePost(data: WelcomeRoom)

    @Delete
    suspend fun deletePost(data: WelcomeRoom)

    /*@Query("SELECT * FROM Post ORDER BY created_utc")
    suspend fun getPostsByDate(): List<Post>

    @Query("SELECT * FROM Post ORDER BY score")
    suspend fun getPostsByVotes(): List<Post>*/

    @Query("SELECT * FROM WelcomeRoom")
    fun getPosts(): Flow<WelcomeRoom>
}