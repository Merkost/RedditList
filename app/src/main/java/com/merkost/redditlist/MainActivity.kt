package com.merkost.redditlist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.paging.Pager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.paging.LoadState
import androidx.paging.PagingConfig
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.merkost.redditlist.compose.RedditListScreen
import com.merkost.redditlist.compose.VideoPlayer
import com.merkost.redditlist.model.entity.ChildData
import com.merkost.redditlist.model.entity.Children
import com.merkost.redditlist.model.entity.PostHint
import com.merkost.redditlist.ui.theme.RedditListTheme
import com.merkost.redditlist.utils.getDate
import com.merkost.redditlist.utils.getVotesNumber
import com.merkost.redditlist.utils.toDate
import com.merkost.redditlist.viewmodels.MainViewModel
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage
import org.koin.androidx.compose.get
import java.lang.reflect.Array.get

private val Color.Companion.LightBlue: Color
    get() {
        return Color(android.graphics.Color.parseColor("#" + "ADD8E6"))
    }

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
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

