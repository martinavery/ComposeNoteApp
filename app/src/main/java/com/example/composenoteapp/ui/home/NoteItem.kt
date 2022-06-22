package com.example.composenoteapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composenoteapp.data.Note

@Composable
fun NoteItem(modifier: Modifier = Modifier, note: Note) {
    Column(modifier
        .clip(RoundedCornerShape(topEnd = 10.dp, bottomStart = 10.dp))
        .background(Color.Gray)
        .padding(8.dp)) {
        note.title?.let {
            Text(
                text = it,
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(8.dp)
            )
        }
        note.description?.let {
            Text(
                text = it,
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview
@Composable
fun NoteItemPreview(
    note: Note = Note(
        title = "Sample title",
        description = "Description goes here"
    )
) {
    NoteItem(note = note)
}
