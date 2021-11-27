package com.merkost.redditlist.model.entity

enum class AwardType(val value: String) {
    Global("global");

    companion object {
        public fun fromValue(value: String): AwardType = when (value) {
            "global" -> Global
            else     -> throw IllegalArgumentException()
        }
    }
}