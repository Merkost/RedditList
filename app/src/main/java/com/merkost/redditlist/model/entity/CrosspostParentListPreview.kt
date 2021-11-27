package com.merkost.redditlist.model.entity

import com.google.gson.annotations.SerializedName

data class CrosspostParentListPreview (
    val images: List<PurpleImage>,

    @SerializedName("reddit_video_preview")
    val redditVideoPreview: RedditVideo,

    val enabled: Boolean
)