package com.merkost.redditlist.model.room.entities

import androidx.room.*

@Entity
data class Post(
    @PrimaryKey(autoGenerate = true)
    val postId: Int? = null,
    val type: String,
    @Embedded
    val postData: PostData?
)