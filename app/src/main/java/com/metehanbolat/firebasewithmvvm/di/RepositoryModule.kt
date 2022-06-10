package com.metehanbolat.firebasewithmvvm.di

import com.google.firebase.firestore.FirebaseFirestore
import com.metehanbolat.firebasewithmvvm.data.repository.NoteRepository
import com.metehanbolat.firebasewithmvvm.data.repository.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideNoteRepository(
        database: FirebaseFirestore
    ) =  NoteRepositoryImpl(database = database)

}