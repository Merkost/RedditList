package com.merkost.redditlist.model.entity

import com.google.gson.annotations.SerializedName

data class MediaEmbed (
    val content: String? = null,
    val width: Long? = null,
    val scrolling: Boolean? = null,
    val height: Long? = null,

    @SerializedName("media_domain_url")
    val mediaDomainURL: String? = null
)