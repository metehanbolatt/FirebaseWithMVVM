package com.metehanbolat.firebasewithmvvm.note

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metehanbolat.firebasewithmvvm.data.model.Note
import com.metehanbolat.firebasewithmvvm.data.repository.NoteRepository
import com.metehanbolat.firebasewithmvvm.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    val repository: NoteRepository
): ViewModel() {

    private val _notes = MutableLiveData<UiState<List<Note>>>()
    val note: LiveData<UiState<List<Note>>> = _notes

    fun getNotes() {
        _notes.value = UiState.Loading
        Handler(Looper.getMainLooper()).postDelayed({
            _notes.value = repository.getNotes()
        }, 2000)

    }
}