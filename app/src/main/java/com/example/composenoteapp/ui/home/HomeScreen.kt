package com.example.composenoteapp.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composenoteapp.data.Note

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(viewModel: NoteViewModel = hiltViewModel()) {

    Scaffold(topBar = { TopBar() }) {
        val optionsScrollState = rememberScrollState()
        Column(modifier = Modifier.scrollable(optionsScrollState, Orientation.Vertical)) {
            NoteForm() { note ->
                viewModel.addNote(note)
            }
            NoteList(
                modifier = Modifier.padding(top = 16.dp),
                notes = viewModel.notes
            )
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

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    HomeScreen()
}