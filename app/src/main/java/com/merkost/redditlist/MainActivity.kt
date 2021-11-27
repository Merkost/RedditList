package com.merkost.redditlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.merkost.redditlist.model.entity.ChildData
import com.merkost.redditlist.ui.theme.RedditListTheme
import com.merkost.redditlist.utils.getDate
import com.merkost.redditlist.utils.toDate
import com.merkost.redditlist.viewmodels.MainViewModel
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage
import org.koin.androidx.compose.get

private val Color.Companion.LightBlue: Color
    get() { return Color(android.graphics.Color.parseColor("#" + "ADD8E6")) }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedditListTheme {
                // A surface container using the 'background' color from the theme
                val viewModel: MainViewModel = get()
                val redditList = viewModel.currentContent.collectAsState()
                Surface(color = Color.LightGray) {
                    if (redditList.value.isNullOrEmpty()) {
                        EmptyView()
                    } else {
                        //Image(painterResource(R.drawable.reddit_logo), "")
                        //Greeting("Android")
                        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            items(redditList.value) { children ->
                                RedditItem(children.data)
                            }
                        }
                    }
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
            Text("Loading movies")
            Spacer(modifier = Modifier.size(8.dp))
            CircularProgressIndicator()
        }
    }
}

@Composable
private fun RedditItem(post: ChildData) {
    Card(modifier = Modifier.padding(4.dp)) {

        Row(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxHeight().weight(2f).fillMaxWidth().background(Color.LightBlue),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,

            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.KeyboardArrowUp, "")
                }


                Text(getVotesNumber(post.score))

                IconButton(onClick = {}) {
                    Icon(Icons.Default.KeyboardArrowDown, "")
                }

            }
            Column(
                modifier = Modifier.weight(14f).fillMaxWidth().padding(6.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Text("Posted by u/${post.author} ${getDate(post.createdUTC.toLong())}", style = MaterialTheme.typography.caption)
                Text(post.title, style = MaterialTheme.typography.h6)
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
        }
    }

}

fun getVotesNumber(upvoteRatio: Long): String {
    return when {
        upvoteRatio < 1000L -> (upvoteRatio).toString() + "k"
        upvoteRatio in 1000..9999 -> (upvoteRatio/1000).toString() + "k"
        upvoteRatio in 10000..99999 -> (upvoteRatio/10000).toString() + "k"
        else -> 1.toString()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RedditListTheme {
        Greeting("Android")
    }
}