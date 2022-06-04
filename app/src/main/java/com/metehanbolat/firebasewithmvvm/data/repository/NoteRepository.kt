package com.metehanbolat.firebasewithmvvm.data.repository

import com.metehanbolat.firebasewithmvvm.data.model.Note
import com.metehanbolat.firebasewithmvvm.util.UiState

interface NoteRepository {

    fun getNotes(): UiState<List<Note>>
}