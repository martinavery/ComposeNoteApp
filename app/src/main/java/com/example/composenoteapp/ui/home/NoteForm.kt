package com.example.composenoteapp.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composenoteapp.data.Note
import com.example.composenoteapp.ui.components.MTextField
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteForm(onNoteAdded: (Note) -> Unit) {
    var titleState by remember {
        mutableStateOf("")
    }
    var descState by remember {
        mutableStateOf("")
    }
    Column {
        MTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), value = titleState, label = "Title", onValueChange = {
            titleState = it
        })
        MTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), value = descState, label = "Description", onValueChange = {
            descState = it
        })
        Button(
            onClick = {
                onNoteAdded(
                    Note(
                        title = titleState,
                        description = descState,
                        dateCreated = LocalDateTime.now()
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
        ) {
            Text(text = "Save", modifier = Modifier.padding(8.dp))
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NotePreview() {
    NoteForm({})
}