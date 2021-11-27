package com.merkost.redditlist.model.entity

enum class SubredditType(val value: String) {
    Public("public");

    companion object {
        public fun fromValue(value: String): SubredditType = when (value) {
            "public" -> Public
            else     -> throw IllegalArgumentException()
        }
    }
}