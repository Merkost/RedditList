package com.merkost.redditlist.model.room.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import com.merkost.redditlist.model.entity.Children

@Entity
data class WelcomeRoomData (
    val after: String = "",
    val dist: Long = 0,
    val modhash: String = "",

    @SerializedName("geo_filter")
    val geoFilter: Any? = null,

    val children: List<Post>,
    val before: Any? = null
)
