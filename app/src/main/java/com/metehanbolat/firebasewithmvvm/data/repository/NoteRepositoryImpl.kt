package com.metehanbolat.firebasewithmvvm.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.metehanbolat.firebasewithmvvm.data.model.Note
import java.util.*

class NoteRepositoryImpl(
    val database: FirebaseFirestore
): NoteRepository {

    override fun getNotes(): List<Note> {
        return arrayListOf(
            Note(
                id = "id 1",
                text = "text 1",
                date = Date()
            ),
            Note(
                id = "id 2",
                text = "text 2",
                date = Date()
            ),
            Note(
                id = "id 3",
                text = "text 3",
                date = Date()
            )
        )
    }

}