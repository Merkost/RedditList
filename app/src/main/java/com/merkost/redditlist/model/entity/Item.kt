package com.merkost.redditlist.model.entity

import com.google.gson.annotations.SerializedName

data class Item (
    @SerializedName("media_id")
    val mediaID: String,

    val id: Long
)