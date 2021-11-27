package com.merkost.redditlist.application

import android.app.Application
import com.merkost.redditlist.di.application
import com.merkost.redditlist.di.mainActivity
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RedditList : Application() {

        override fun onCreate() {
            super.onCreate()
            startKoin {
                // Koin Android logger
                androidLogger()
                //inject Android context
                androidContext(this@RedditList)
                modules(
                    listOf(
                        application,
                        mainActivity
                    )
                )
            }
        }
    }