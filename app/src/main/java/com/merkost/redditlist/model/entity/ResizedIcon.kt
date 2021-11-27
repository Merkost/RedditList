package com.merkost.redditlist.model.entity

data class ResizedIcon (
    val url: String,
    val width: Long,
    val height: Long,
    val format: Format? = null
)