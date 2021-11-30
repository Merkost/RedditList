package com.merkost.redditlist.model.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.merkost.redditlist.model.room.entities.Post
import java.lang.reflect.Type

import java.util.Collections
class PostConverter {

    companion object {
        val gson = Gson()
    }

    @TypeConverter
    fun stringToListPost(data: String?): List<Post?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object :
            TypeToken<List<Post?>?>() {}.type
        return gson.fromJson<List<Post?>>(data, listType)
    }

    @TypeConverter
    fun listPostToString(someObjects: List<Post?>?): String? {
        return gson.toJson(someObjects)
    }
}