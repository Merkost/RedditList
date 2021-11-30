package com.merkost.redditlist.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.merkost.redditlist.model.room.dao.WelcomeRoomDao
import com.merkost.redditlist.model.room.entities.*

@Database(
    entities = [WelcomeRoom::class, WelcomeRoomData::class,
        Posts::class, Post::class, PostData::class], version = 3
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun welcomeRoomDao(): WelcomeRoomDao

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
            "myDB"
        ).fallbackToDestructiveMigration().build()

}