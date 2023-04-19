package com.merkost.redditlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.merkost.redditlist.compose.RedditListScreen
import com.merkost.redditlist.ui.theme.RedditListTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedditListTheme {
                RedditListScreen()
            }
        }
    }
}

