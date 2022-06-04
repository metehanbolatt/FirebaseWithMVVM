package com.metehanbolat.firebasewithmvvm.data.repository

import com.metehanbolat.firebasewithmvvm.data.model.Note

class NoteRepositoryImpl: NoteRepository {

    override fun getNotes(): List<Note> {
        return arrayListOf()
    }

}