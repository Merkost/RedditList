package com.merkost.redditlist.model.entity

enum class TranscodingStatus(val value: String) {
    Completed("completed");

    companion object {
        public fun fromValue(value: String): TranscodingStatus = when (value) {
            "completed" -> Completed
            else        -> throw IllegalArgumentException()
        }
    }
}