package com.example.composenoteapp.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.composenoteapp.data.DataSource


@Composable
fun NoteList() {
    val source = DataSource()
    val notes = source.fetchNotes()
    androidx.compose.material.Surface(
        modifier = Modifier.nestedScroll()
    ) {

    }
    LazyColumn() {
        items(items = notes, key = {
            it.id
        }) { note ->
            NoteItem(note = note)
        }
    }
}

@Preview
@Composable
fun NoteListPreview() {
    NoteList()
}