package com.merkost.redditlist.model.entity

import com.google.gson.annotations.SerializedName

data class RedditVideo (
    @SerializedName("bitrate_kbps")
    val bitrateKbps: Long = 0,

    @SerializedName("fallback_url")
    val fallbackURL: String = "",

    val height: Long = 0,
    val width: Long = 0,

    @SerializedName("scrubber_media_url")
    val scrubberMediaURL: String = "",

    @SerializedName("dash_url")
    val dashURL: String = "",

    val duration: Long = 0,

    @SerializedName("hls_url")
    val hlsURL: String = "",

    @SerializedName("is_gif")
    val isGIF: Boolean = false,

    @SerializedName("transcoding_status")
    val transcodingStatus: TranscodingStatus? = null
)