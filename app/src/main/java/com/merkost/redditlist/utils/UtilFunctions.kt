package com.merkost.redditlist.utils

import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.util.*

fun String.toDate(dateFormat: String = "yyyy-MM-dd HH:mm:ss", timeZone: TimeZone = TimeZone.getTimeZone("UTC")): Date {
    val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
    parser.timeZone = timeZone
    return parser.parse(this)
}

fun Date.formatTo(dateFormat: String, timeZone: TimeZone = TimeZone.getDefault()): String {
    val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
    formatter.timeZone = timeZone
    return formatter.format(this)
}

fun getDate(timestamp: Long) = Instant.ofEpochSecond(timestamp)
    .atZone(ZoneId.systemDefault())
    .toLocalDateTime()

/*
fun getHours(timestamp: Long) {
    var hours = Math.abs(Date() - getDate(timestamp)) / 36e5;
}*/
