package com.merkost.redditlist.model.entity

import com.google.gson.annotations.SerializedName

data class Welcome1Data (
    val after: String,
    val dist: Long,
    val modhash: String,

    @SerializedName("geo_filter")
    val geoFilter: Any? = null,

    val children: List<Children>,
    val before: Any? = null
)
