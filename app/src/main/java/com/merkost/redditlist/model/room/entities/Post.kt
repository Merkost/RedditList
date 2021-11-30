package com.merkost.redditlist.model.room.entities

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(
    foreignKeys = [ForeignKey(
        entity = WelcomeRoomData::class,
        parentColumns = arrayOf("welcomeDataId"),
        childColumns = arrayOf("welcomeFK"),
        onDelete = CASCADE
    )]
)
data class Post(
    @PrimaryKey(autoGenerate = true)
    val postId: Int? = null,
    val type: String,
    val welcomeFK: Int,
    @Embedded
    val postData: PostData?
)