package com.example.exp12

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val text: String,
    val isSent: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)