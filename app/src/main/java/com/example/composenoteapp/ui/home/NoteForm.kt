package com.example.composenoteapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composenoteapp.ui.components.MTextField

@Composable
fun NoteForm() {
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
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
        ) {
            Text(text = "Save", modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NotePreview() {
    NoteForm()
}