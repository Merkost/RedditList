package com.merkost.redditlist.model.entity

enum class FlairType(val value: String) {
    Text("text");

    companion object {
        public fun fromValue(value: String): FlairType = when (value) {
            "text" -> Text
            else   -> throw IllegalArgumentException()
        }
    }
}