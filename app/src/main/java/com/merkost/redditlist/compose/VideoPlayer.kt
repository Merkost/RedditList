package com.merkost.redditlist.compose

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView

@Composable
@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
fun VideoPlayer(sourceUrl: String) {
    // This is the official way to access current context from Composable functions
    val context = LocalContext.current

    // Do not recreate the player everytime this Composable commits
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val defaultDataSourceFactory: DataSource.Factory = DefaultDataSource.Factory(context)
            val dataSourceFactory: DataSource.Factory = DefaultDataSource.Factory(
                context,
                defaultDataSourceFactory
            )

            val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(
                    MediaItem.fromUri(
                        sourceUrl
                    // Big Buck Bunny from Blender Project
                    //"https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                ))

            setMediaSource(source)
            videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
            playbackState;
            playWhenReady = true
            repeatMode = Player.REPEAT_MODE_ALL;
            this.prepare()
        }
    }

    VideoPlayer(modifier = Modifier, exoPlayer = exoPlayer)

}

@Composable
@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
fun VideoPlayer(modifier: Modifier = Modifier, exoPlayer: ExoPlayer) {
    val context = LocalContext.current

    ConstraintLayout(modifier = modifier) {
        val (title, videoPlayer) = createRefs()

        // video title
        Text(
            text = "Current Title",
            color = Color.White,
            modifier =
            Modifier.padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        exoPlayer.play()
        // player view
        DisposableEffect(
            AndroidView(
                modifier =
                Modifier.testTag("VideoPlayer")
                    .constrainAs(videoPlayer) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                factory = {

                    // exo player view for our video player
                    PlayerView(context).apply {
                        player = exoPlayer
                        layoutParams =
                            FrameLayout.LayoutParams(
                                ViewGroup.LayoutParams
                                    .MATCH_PARENT,
                                ViewGroup.LayoutParams
                                    .MATCH_PARENT
                            )
                        controllerAutoShow = false
                        resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                        useController = false
                        //useController = false
                    }
                }
            )

        ) {
            onDispose {
                // relase player when no longer needed
                exoPlayer.release()
            }
        }

    }
}

