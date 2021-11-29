package com.merkost.redditlist.model.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [Index("created_utc"), Index("score")])
data class PostData(
    @PrimaryKey(autoGenerate = true)
    val postDataId: Int? = null,
    val score: Long,
    val author: String,
    @ColumnInfo(name = "created_utc")
    val createdUTC: Long,
    val title: String,
    val postHint: String?,
    @ColumnInfo(name = "video_url")
    val videoURL: String = "",
    @ColumnInfo(name = "image_url")
    val imgURL: String = "",
    val url: String,
    @ColumnInfo(name = "comments_num")
    val numComments: Long,
)