package com.merkost.redditlist.model.entity

data class GIF (
    val source: ResizedIcon,
    val resolutions: List<ResizedIcon>
)