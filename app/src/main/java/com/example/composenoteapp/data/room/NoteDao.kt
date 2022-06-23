package com.example.composenoteapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.composenoteapp.data.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    suspend fun fetchNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note): Void

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun fetchNoteById(id: String): Note
}