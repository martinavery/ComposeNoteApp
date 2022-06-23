package com.example.composenoteapp.data

class DataSource {
    private val notes = arrayListOf(
        Note(
            title = "Note 1",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        ),
        Note(
            title = "Note 1",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        ),
    )

    fun fetchNotes(): ArrayList<Note> {
        return notes
    }

    fun addNote(note: Note) {
        notes.add(note)
    }
}