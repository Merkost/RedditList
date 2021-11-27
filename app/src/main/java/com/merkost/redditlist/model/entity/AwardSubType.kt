package com.merkost.redditlist.model.entity

enum class AwardSubType(val value: String) {
    Appreciation("APPRECIATION"),
    Global("GLOBAL"),
    Group("GROUP"),
    Premium("PREMIUM");

    companion object {
        public fun fromValue(value: String): AwardSubType = when (value) {
            "APPRECIATION" -> Appreciation
            "GLOBAL"       -> Global
            "GROUP"        -> Group
            "PREMIUM"      -> Premium
            else           -> throw IllegalArgumentException()
        }
    }
}