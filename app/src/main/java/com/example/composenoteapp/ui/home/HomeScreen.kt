package com.example.composenoteapp.ui.home

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Scaffold(topBar = { TopBar() }) {
        val optionsScrollState = rememberScrollState()
        Column(modifier = Modifier.scrollable(optionsScrollState, Orientation.Vertical)) {
            NoteForm()
            NoteList()
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar() {
        Text(
            text = "Notes", modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp), style = TextStyle(
                fontSize = 16.sp
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    HomeScreen()
}