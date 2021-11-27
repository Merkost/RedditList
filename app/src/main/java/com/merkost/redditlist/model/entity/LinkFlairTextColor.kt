package com.merkost.redditlist.model.entity

enum class LinkFlairTextColor(val value: String) {
    Dark("dark");

    companion object {
        public fun fromValue(value: String): LinkFlairTextColor = when (value) {
            "dark" -> Dark
            else   -> throw IllegalArgumentException()
        }
    }
}