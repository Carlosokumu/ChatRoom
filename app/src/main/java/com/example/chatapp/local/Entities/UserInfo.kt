package com.example.chatapp.local.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserInfo(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var messageContent: String) {
}