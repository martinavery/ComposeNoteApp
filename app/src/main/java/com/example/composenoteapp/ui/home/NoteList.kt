package com.example.composenoteapp.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.example.composenoteapp.data.DataSource
import com.example.composenoteapp.data.Note
import com.example.composenoteapp.data.Resulta
import kotlinx.coroutines.flow.StateFlow


@Composable
fun NoteList(modifier: Modifier = Modifier, notes: LiveData<Resulta<List<Note>>>) {
    val n = notes.observeAsState()
    when (n.value?.status) {
        Resulta.Status.SUCCESS -> {
            if (!n.value!!.data.isNullOrEmpty()) {
                LazyColumn(modifier = modifier) {
                    items(items = n.value!!.data!!, key = {
                        it.id
                    }) { note ->
                        NoteItem(note = note, modifier = Modifier.padding(16.dp))
                    }
                }
            } else {
                Text(text = "No notes")
            }
        }
        Resulta.Status.LOADING -> {
            CircularProgressIndicator()
        }
        Resulta.Status.ERROR -> {

        }
    }
}
