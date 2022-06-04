package com.metehanbolat.firebasewithmvvm.data.repository

import com.metehanbolat.firebasewithmvvm.data.model.Note

interface NoteRepository {

    fun getNotes(): List<Note>
}