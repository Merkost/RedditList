package com.merkost.redditlist.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.merkost.redditlist.model.room.dao.WelcomeDao
import com.merkost.redditlist.model.room.entities.Post
import com.merkost.redditlist.model.room.entities.PostData
import com.merkost.redditlist.model.room.entities.WelcomeRoom
import com.merkost.redditlist.model.room.entities.WelcomeRoomData

@Database(entities = [WelcomeRoom::class, WelcomeRoomData::class,
    Post::class, PostData::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun welcomeDao(): WelcomeDao

}

object DatabaseBuilder {

    private var INSTANCE: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "mindorks-example-coroutines"
        ).fallbackToDestructiveMigration().build()

}