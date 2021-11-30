package com.merkost.redditlist.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Posts(
    @PrimaryKey(autoGenerate = true)
    val postsId: Int? = null,
    val post: Post
)
