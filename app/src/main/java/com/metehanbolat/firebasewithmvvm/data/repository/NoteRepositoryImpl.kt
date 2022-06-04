package com.metehanbolat.firebasewithmvvm.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.metehanbolat.firebasewithmvvm.data.model.Note
import com.metehanbolat.firebasewithmvvm.util.UiState
import java.util.*

class NoteRepositoryImpl(
    val database: FirebaseFirestore
): NoteRepository {

    override fun getNotes(): UiState<List<Note>> {
        val data = listOf<Note>()

        return if (data.isEmpty()) {
            UiState.Failure("Data is Empty")
        } else {
            UiState.Success(data)
        }
    }

}