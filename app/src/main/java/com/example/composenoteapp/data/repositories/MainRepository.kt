package com.example.composenoteapp.data.repositories

import com.example.composenoteapp.data.Note
import com.example.composenoteapp.data.Resulta
import com.example.composenoteapp.data.room.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainRepository(private val db: RoomDatabase) : NoteRepository {
    override fun fetchNotes(): Flow<Resulta<List<Note>>> {
        return flow {
            emit(Resulta.loading())
            db.noteDao().fetchNotes().collect {
                emit(Resulta.success(it))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun addNote(note: Note): Flow<Resulta<Void>> {
        return flow {
            emit(Resulta.loading())
            emit(Resulta.success(db.noteDao().addNote(note)))
        }.flowOn(Dispatchers.IO)
    }

    override fun fetchNoteById(noteId: String): Flow<Resulta<Note>> {
        return flow {
            emit(Resulta.loading())
            emit(Resulta.success(db.noteDao().fetchNoteById(noteId)))
        }.flowOn(Dispatchers.IO)
    }
}