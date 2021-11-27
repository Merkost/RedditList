package com.merkost.redditlist.model.entity

enum class Domain(val value: String) {
    DiscordGg("discord.gg"),
    GfycatCOM("gfycat.com"),
    IReddIt("i.redd.it"),
    RedditCOM("reddit.com"),
    VReddIt("v.redd.it");

    companion object {
        public fun fromValue(value: String): Domain = when (value) {
            "discord.gg" -> DiscordGg
            "gfycat.com" -> GfycatCOM
            "i.redd.it"  -> IReddIt
            "reddit.com" -> RedditCOM
            "v.redd.it"  -> VReddIt
            else         -> throw IllegalArgumentException()
        }
    }
}