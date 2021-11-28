package com.merkost.redditlist.compose

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.merkost.redditlist.model.entity.ChildData
import com.merkost.redditlist.model.entity.Children
import com.merkost.redditlist.model.entity.PostHint
import com.merkost.redditlist.utils.getDate
import com.merkost.redditlist.utils.getVotesNumber
import com.merkost.redditlist.viewmodels.MainViewModel
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage
import org.koin.androidx.compose.get

@ExperimentalAnimationApi
@Composable
fun RedditListScreen() {
    // A surface container using the 'background' color from the theme
    val viewModel: MainViewModel = get()

    val data = viewModel.children

    //val redditList = viewModel.currentContent.collectAsState()
    Surface(color = Color.LightGray) {

            val listItems: LazyPagingItems<Children> = data.collectAsLazyPagingItems()
            LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp)) {

                items(listItems) { children ->

                    children?.let {
                        RedditItem(it.data)
                    }
                }
            }
            listItems.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        EmptyView()
                        //You can add modifier to manage load state when first time response page is loading
                    }
                    loadState.append is LoadState.Loading -> {
                        EmptyView()
                        //You can add modifier to manage load state when next response page is loading
                    }
                    loadState.append is LoadState.Error -> {
                        //You can use modifier to show error message
                    }
                }
            }

    }
}

@Composable
fun EmptyView() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Loading hot posts from Reddit")
            Spacer(modifier = Modifier.size(8.dp))
            CircularProgressIndicator()
        }
    }
}

@Composable
private fun RedditItem(post: ChildData) {
    val context = LocalContext.current

    Card(modifier = Modifier.padding(4.dp)) {

        Row(modifier = Modifier.fillMaxSize().padding(4.dp)) {
            Column(
                modifier = Modifier.fillMaxHeight().weight(2f).fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,

                ) {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.KeyboardArrowUp, "")
                }

                Text(getVotesNumber(post.score))

                IconButton(onClick = { }) {
                    Icon(Icons.Default.KeyboardArrowDown, "")
                }

            }
            Column(
                modifier = Modifier.weight(14f).fillMaxWidth().padding(4.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically)
            ) {

                Text(
                    "Posted by u/${post.author} ${getDate(post.createdUTC.toLong())}",
                    style = MaterialTheme.typography.caption
                )

                Text(post.title, style = MaterialTheme.typography.h6)

                when (post.postHint) {
                    PostHint.HostedVideo.value -> {
                        post.media?.redditVideo?.fallbackURL?.let { VideoPlayer(it) }
                        Log.d("VIDEO", post.url)
                    }
                    PostHint.Image.value -> {
                        CoilImage(
                            imageModel = post.url,
                            contentScale = ContentScale.FillWidth,
                            shimmerParams = ShimmerParams(
                                baseColor = Color.LightGray,
                                highlightColor = Color.White,
                                durationMillis = 580,
                                dropOff = 0.65f,
                                tilt = 20f,
                            ),
                            failure = {
                                Text("Image request failed")
                            }
                        )
                    }
                    else -> {
                        Text(post.urlOverriddenByDest, color = Color.Blue,
                            textDecoration = TextDecoration.Underline,
                            modifier = Modifier.clickable {
                                ContextCompat.startActivity(
                                    context, Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(post.urlOverriddenByDest)
                                    ), null
                                )
                            })
                    }
                }
            }
        }
    }
}