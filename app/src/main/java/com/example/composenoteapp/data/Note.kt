package com.example.composenoteapp.data

import java.time.LocalDateTime
import java.util.*

data class Note(
    val id: String = UUID.randomUUID().toString(),
    var title: String? = null,
    var description: String? = null,
    var dateCreated: LocalDateTime? = null
)
