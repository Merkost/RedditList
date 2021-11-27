package com.merkost.redditlist.model.entity

data class FluffyImage (
    val source: ResizedIcon,
    val resolutions: List<ResizedIcon>,
    val variants: Variants,
    val id: String
)