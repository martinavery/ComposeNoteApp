package com.example.composenoteapp.di

import android.content.Context
import androidx.room.Room
import com.example.composenoteapp.data.repositories.MainRepository
import com.example.composenoteapp.data.room.NoteDao
import com.example.composenoteapp.data.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): RoomDatabase {
        return Room.databaseBuilder(context, RoomDatabase::class.java, "database").build()
    }

    @Singleton
    @Provides
    fun provideNoteDao(db: RoomDatabase): NoteDao {
        return db.noteDao()
    }

    @Singleton
    @Provides
    fun provideMainRepository(db: RoomDatabase): MainRepository {
        return MainRepository(db)
    }
}