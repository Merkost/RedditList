package com.merkost.redditlist.model.room.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.merkost.redditlist.model.entity.Welcome1Data

@Entity
data class WelcomeRoom(
    @PrimaryKey(autoGenerate = true)
    val welcomeId: Int? = null,
    val kind: String? = null,
    @Embedded
    var data: WelcomeRoomData?
)
