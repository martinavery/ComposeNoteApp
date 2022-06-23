package com.example.composenoteapp.data.repositories

import com.example.composenoteapp.data.Note
import com.example.composenoteapp.data.Resulta
import com.example.composenoteapp.data.room.NoteDao
import com.example.composenoteapp.data.room.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface NoteRepository {
    fun fetchNotes(): Flow<Resulta<List<Note>>>
    fun addNote(note: Note): Flow<Resulta<Void>>
    fun fetchNoteById(noteId: String): Flow<Resulta<Note>>
}