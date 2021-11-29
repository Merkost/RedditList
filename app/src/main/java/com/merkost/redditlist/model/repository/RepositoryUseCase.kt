package com.merkost.redditlist.model.repository

import com.merkost.redditlist.model.entity.Children
import com.merkost.redditlist.model.entity.Welcome1
import com.merkost.redditlist.model.room.DatabaseHelper
import com.merkost.redditlist.model.room.entities.Post
import com.merkost.redditlist.model.room.entities.WelcomeRoom
import com.merkost.redditlist.model.room.entities.WelcomeRoomData
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

private val List<Children>.toPosts: List<Post>
    get() {
        val list = mutableListOf<Post>()
        this.forEach {
            list.add(Post(
                it.kind
            ))
        }
    }
private val Welcome1.mapToWelcomeRoom: WelcomeRoom
    get() {
        return WelcomeRoom(
            kind = kind,
            data = WelcomeRoomData(
                after = this.data.after,
                before = this.data.before,
                children = this.data.children.toPosts
            )
        )
    }

class RepositoryUseCase(val repository: RedditRepository, val dbHelper: DatabaseHelper)  {

    suspend fun getPostsPager(after: String?) = flow<Welcome1> {
        coroutineScope {
            val data = repository.getHotPostsPager(after)
            emit(data)
            dbHelper.insertPosts(data.mapToWelcomeRoom)
        }
    }

    /*data.map { children ->
        Post(
            type = children.kind,
            after = welcomeData!!.after,
            before = welcomeData!!.before as String?,
            postData = children.data.mapToPostData
        )
    }*/

}