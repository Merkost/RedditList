package com.merkost.redditlist.compose

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.merkost.redditlist.model.entity.ChildData
import com.merkost.redditlist.model.entity.Children
import com.merkost.redditlist.model.entity.PostHint
import com.merkost.redditlist.utils.*
import com.merkost.redditlist.viewmodels.MainViewModel
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage
import org.koin.androidx.compose.get

@ExperimentalAnimationApi
@Composable
fun RedditListScreen() {
    // A surface container using the 'background' color from the theme
    val viewModel: MainViewModel = get()
    val shouldShowLoadingView = remember { mutableStateOf(false) }
    val data = viewModel.children

    //val redditList = viewModel.currentContent.collectAsState()
    Scaffold(backgroundColor = Color.MyLightGray) {
        ConstraintLayout {
            val (list, loadingView) = createRefs()

            AnimatedVisibility(
                visible = shouldShowLoadingView.value,
                enter = fadeIn(animationSpec = tween(300)),
                exit = fadeOut(animationSpec = tween(300)),
                modifier = Modifier.constrainAs(loadingView) {
                    top.linkTo(parent.top, 16.dp)
                    absoluteLeft.linkTo(parent.absoluteLeft)
                    absoluteRight.linkTo(parent.absoluteRight)
                }.zIndex(5f)
            ) {
                LoadingView(
                    modifier = Modifier.wrapContentSize(),
                )
            }

            val listItems: LazyPagingItems<Children> = data.collectAsLazyPagingItems()
            LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.fillMaxSize().zIndex(1f).constrainAs(list) {
                    top.linkTo(parent.top)
                    absoluteLeft.linkTo(parent.absoluteLeft)
                    absoluteRight.linkTo(parent.absoluteRight)
                    bottom.linkTo(parent.bottom)
                }) {
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
                        shouldShowLoadingView.value = true
                        //You can add modifier to manage load state when next response page is loading
                    }
                    loadState.append is LoadState.Error -> {
                        //You can use modifier to show error message
                    }
                    loadState.append is LoadState.NotLoading -> {
                        shouldShowLoadingView.value = false
                    }
                }
            }
        }
    }
}

@Composable
fun LoadingView(modifier: Modifier) {
    Card(
        shape = RoundedCornerShape(size = 20.dp),
        modifier = modifier
            .heightIn(min = 40.dp, max = 80.dp)
            .wrapContentWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ).padding(4.dp),
    ) {
        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(6.dp).padding(horizontal = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(25.dp)
            )
            Spacer(Modifier.size(6.dp))
            Text(
                "Loading more items...",
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray,
                modifier = Modifier.padding(end = 2.dp)
            )
            Spacer(Modifier.size(4.dp))
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

        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxHeight().weight(2f).fillMaxWidth().background(Color.MyLightBlue),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,

                ) {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.KeyboardArrowUp, "")
                }

                Text(getVotesNumber(post.score), overflow = TextOverflow.Visible)

                IconButton(onClick = { }) {
                    Icon(Icons.Default.KeyboardArrowDown, "")
                }

            }
            Column(
                modifier = Modifier.weight(14f).fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().fillMaxSize().padding(4.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically)
                ) {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            "Posted by u/${post.author}",
                            style = MaterialTheme.typography.caption,
                            color = Color.Gray
                        )
                        Text(
                            "${getDate(post.createdUTC.toLong())}",
                            style = MaterialTheme.typography.caption,
                            color = Color.Gray
                        )
                    }


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
                    Spacer(modifier = Modifier.size(8.dp))
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = {}) {
                        Icon(
                            Icons.Default.Comment,
                            Icons.Default.Comment.name,
                            tint = Color.Gray
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            "${post.numComments} Comments",
                            style = MaterialTheme.typography.caption,
                            color = Color.Gray
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.End),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(onClick = {}) {
                            Icon(
                                Icons.Default.Share,
                                Icons.Default.Share.name,
                                tint = Color.Gray
                            )
                            Spacer(modifier = Modifier.size(4.dp))
                            Text(
                                "Share",
                                style = MaterialTheme.typography.caption,
                                color = Color.Gray
                            )
                        }
                        TextButton(onClick = {}) {
                            Icon(
                                Icons.Default.Save,
                                Icons.Default.Share.name,
                                tint = Color.Gray
                            )
                            Spacer(modifier = Modifier.size(4.dp))
                            Text(
                                "Save",
                                style = MaterialTheme.typography.caption,
                                color = Color.Gray
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.MoreHoriz,
                                Icons.Default.More.name,
                                tint = Color.Gray
                            )
                        }
                    }
                }

            }
        }
    }
}