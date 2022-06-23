package com.example.composenoteapp.ui.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composenoteapp.data.DataSource
import com.example.composenoteapp.data.Note
import com.example.composenoteapp.data.Resulta
import com.example.composenoteapp.data.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    private val _notes = MutableStateFlow<Resulta<List<Note>>>(Resulta.loading())
    val notes = _notes.asStateFlow()

    init {
        viewModelScope.launch {
            repository.fetchNotes().distinctUntilChanged().collect {
                _notes.value = it
            }
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch {
            repository.addNote(note).collectLatest {

            }
        }
    }


}