package com.merkost.redditlist.model.entity

enum class PostHint(val value: String) {
    HostedVideo("hosted:video"),
    Image("image"),
    Link("link"),
    RichVideo("rich:video");

    companion object {
        public fun fromValue(value: String): PostHint = when (value) {
            "hosted:video" -> HostedVideo
            "image"        -> Image
            "link"         -> Link
            "rich:video"   -> RichVideo
            else           -> throw IllegalArgumentException()
        }
    }
}