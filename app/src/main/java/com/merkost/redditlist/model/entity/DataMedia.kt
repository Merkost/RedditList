package com.merkost.redditlist.model.entity

import com.google.gson.annotations.SerializedName

data class DataMedia (
    @SerializedName("reddit_video")
    val redditVideo: RedditVideo? = null,

    val oembed: Oembed? = null,
    val type: Domain? = null
)