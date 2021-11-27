package com.merkost.redditlist.model.entity

import com.google.gson.annotations.SerializedName

data class DataGildings (
    @SerializedName("gid_1")
    val gid1: Long? = null,

    @SerializedName("gid_2")
    val gid2: Long? = null
)