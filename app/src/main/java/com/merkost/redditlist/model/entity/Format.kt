package com.merkost.redditlist.model.entity

enum class Format(val value: String) {
    Apng("APNG"),
    PNG("PNG");

    companion object {
        public fun fromValue(value: String): Format = when (value) {
            "APNG" -> Apng
            "PNG"  -> PNG
            else   -> throw IllegalArgumentException()
        }
    }
}