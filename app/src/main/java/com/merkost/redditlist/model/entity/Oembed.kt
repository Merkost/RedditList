package com.merkost.redditlist.model.entity

import com.google.gson.annotations.SerializedName

data class Oembed (
    @SerializedName("provider_url")
    val providerURL: String,

    val description: String,
    val title: String,
    val type: String,

    @SerializedName("author_name")
    val authorName: String,

    val height: Long,
    val width: Long,
    val html: String,

    @SerializedName("thumbnail_width")
    val thumbnailWidth: Long,

    val version: String,

    @SerializedName("provider_name")
    val providerName: String,

    @SerializedName("thumbnail_url")
    val thumbnailURL: String,

    @SerializedName("thumbnail_height")
    val thumbnailHeight: Long
)