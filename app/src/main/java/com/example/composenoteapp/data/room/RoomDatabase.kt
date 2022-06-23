package com.example.composenoteapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composenoteapp.data.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}