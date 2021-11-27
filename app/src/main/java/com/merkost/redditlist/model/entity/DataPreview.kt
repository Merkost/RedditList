package com.merkost.redditlist.model.entity

import com.google.gson.annotations.SerializedName

data class DataPreview (
    val images: List<FluffyImage>,
    val enabled: Boolean,

    @SerializedName("reddit_video_preview")
    val redditVideoPreview: RedditVideo? = null
)