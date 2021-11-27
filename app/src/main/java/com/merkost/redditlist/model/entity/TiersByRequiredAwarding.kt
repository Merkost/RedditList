package com.merkost.redditlist.model.entity

import com.google.gson.annotations.SerializedName

data class TiersByRequiredAwarding (
    @SerializedName("resized_icons")
    val resizedIcons: List<ResizedIcon>,

    @SerializedName("awardings_required")
    val awardingsRequired: Long,

    @SerializedName("static_icon")
    val staticIcon: ResizedIcon,

    @SerializedName("resized_static_icons")
    val resizedStaticIcons: List<ResizedIcon>,

    val icon: ResizedIcon
)