package com.merkost.redditlist.model.entity

data class PurpleImage (
    val source: ResizedIcon,
    val resolutions: List<ResizedIcon>,
    val variants: VariantsClass,
    val id: String
)