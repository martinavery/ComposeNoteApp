package com.example.composenoteapp.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composenoteapp.data.DataSource


@Composable
fun NoteList(modifier: Modifier = Modifier) {
    val source = DataSource()
    val notes = source.fetchNotes()
    LazyColumn() {
        items(items = notes, key = {
            it.id
        }) { note ->
            NoteItem(note = note, modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview
@Composable
fun NoteListPreview() {
    NoteList()
}