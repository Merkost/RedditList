package com.merkost.redditlist.model.room.entities

import androidx.room.*

@Entity
data class Post(
    @PrimaryKey(autoGenerate = true)
    val postId: Int? = null,
    val type: String,
    val after: String,
    val before: String? = null,
    @Embedded
    val postData: PostData?
)