package com.merkost.redditlist.model.room.entities

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.merkost.redditlist.model.entity.Children
import com.merkost.redditlist.model.room.PostConverter

@Entity
data class WelcomeRoomData (
    @PrimaryKey(autoGenerate = true)
    val welcomeDataId: Int? = null,
    val after: String = "",
    @TypeConverters(PostConverter::class)
    @Relation(
        parentColumn = "welcomeDataId",
        entityColumn = "welcomeFK",
        entity = Post::class
    )
    val children: List<Post>,
    val before: String? = ""
)
