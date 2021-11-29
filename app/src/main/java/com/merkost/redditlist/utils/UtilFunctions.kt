package com.merkost.redditlist.utils

import android.R.attr
import android.icu.text.DecimalFormat
import androidx.compose.ui.graphics.Color
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*
import android.R.attr.end
import com.merkost.redditlist.model.entity.ChildData
import com.merkost.redditlist.model.entity.DataMedia
import com.merkost.redditlist.model.entity.RedditVideo
import com.merkost.redditlist.model.room.entities.PostData
import java.time.*
import java.time.format.FormatStyle

val ChildData.mapToPostData: PostData?
    get() {
        return PostData(
            score=score,
            author=author,
            createdUTC=createdUTC.toLong(),
            title=title,
            postHint=postHint,
            videoURL=media?.redditVideo?.fallbackURL ?: "",
            imgURL=url,
            url=urlOverriddenByDest,
            numComments=numComments,
        )
    }

val PostData.toChildData: ChildData
    get() {
        return ChildData(
            score = score,
            author = author,
            createdUTC = createdUTC.toDouble(),
            title = title,
            postHint = postHint,
            media = DataMedia(redditVideo = RedditVideo(fallbackURL = videoURL)),
            url = imgURL,
            numComments = numComments,
        )
    }

val Color.Companion.MyLightBlue: Color
    get() {
        return Color(android.graphics.Color.parseColor("#fbfbfb"))
    }

val Color.Companion.MyLightGray: Color
    get() {
        return Color(android.graphics.Color.parseColor("#ebebeb"))
    }

object VotesFormat {
    var format1: DecimalFormat = DecimalFormat("#.#")
    var format2: DecimalFormat = DecimalFormat("##.#")
}

fun String.toDate(
    dateFormat: String = "yyyy-MM-dd HH:mm:ss",
    timeZone: TimeZone = TimeZone.getTimeZone("UTC")
): Date {
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
    .toLocalDateTime().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))

/*fun getDateDifference(givenDatetime: Long): String {
    val givenDate = getDate(givenDatetime)
    val currentDate = getCurrentDate()

    // get the calendar period between the times (years, months & days)
    // get the calendar period between the times (years, months & days)
    var period = Period.between(LocalDate.parse(givenDatetime.toString()), LocalDate.now())
    // make sure to get the floor of the number of days
    // make sure to get the floor of the number of days
    period = period.minusDays(
        if (end.toLocalTime().compareTo(start.toLocalTime()) >= 0) 0 else 1.toLong()
    )

    // get the remainder as a duration (hours, minutes, etc.)

    // get the remainder as a duration (hours, minutes, etc.)
    var duration: Duration = Duration.between(start, end)
    // remove days, already counted in the period
    // remove days, already counted in the period
    duration = duration.minusDays(duration.toDaysPart())


    // period give us Year, Month, Week and Days
    // days are between 0 to 6
    // if you want to calculate days not weeks
    //you just add 1 and multiply weeks by 7

    val mDays: Int = period.days + (period.weeks * 7) + 1

    return "Year: ${period.years}\nMonth: ${period.months}\nDay: $mDays"
}*/

fun getCurrentDate(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT)
    return sdf.format(Date())
}

// for jvm
private fun epochMillis(): Long = System.currentTimeMillis()

/*
fun getHours(timestamp: Long) {
    var hours = Math.abs(Date() - getDate(timestamp)) / 36e5;
}*/

fun getVotesNumber(upvoteRatio: Long): String {
    val upvoteRatioDouble = upvoteRatio.toDouble()
    return when {
        upvoteRatio < 1000L -> (upvoteRatio).toString()
        upvoteRatio in 1000..9999 -> VotesFormat.format1.format(upvoteRatioDouble / 1000) + "k"
        upvoteRatio in 10000..99999 -> VotesFormat.format2.format(upvoteRatioDouble / 10000) + "k"
        else -> 1.toString()
    }
}