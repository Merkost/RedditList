package com.merkost.redditlist.model.entity

import com.google.gson.annotations.SerializedName

data class RedditVideo (
    @SerializedName("bitrate_kbps")
    val bitrateKbps: Long,

    @SerializedName("fallback_url")
    val fallbackURL: String,

    val height: Long,
    val width: Long,

    @SerializedName("scrubber_media_url")
    val scrubberMediaURL: String,

    @SerializedName("dash_url")
    val dashURL: String,

    val duration: Long,

    @SerializedName("hls_url")
    val hlsURL: String,

    @SerializedName("is_gif")
    val isGIF: Boolean,

    @SerializedName("transcoding_status")
    val transcodingStatus: TranscodingStatus
)