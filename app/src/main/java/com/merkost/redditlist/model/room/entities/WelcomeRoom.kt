package com.merkost.redditlist.model.room.entities

import androidx.room.Entity
import com.merkost.redditlist.model.entity.Welcome1Data

@Entity
data class WelcomeRoom(
    val kind: String,
    val data: WelcomeRoomData
)
