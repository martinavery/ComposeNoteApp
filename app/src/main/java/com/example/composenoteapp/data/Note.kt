package com.example.composenoteapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "note")
data class Note(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    var title: String? = null,
    var description: String? = null,
   // var dateCreated: LocalDateTime? = null
)
