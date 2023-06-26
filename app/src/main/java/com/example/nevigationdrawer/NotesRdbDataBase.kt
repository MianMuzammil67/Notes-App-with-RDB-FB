package com.example.nevigationdrawer

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nevigationdrawer.dataClass.NotesEntity

@Database(entities = [NotesEntity::class], version = 1)
abstract class NotesRdbDataBase : RoomDatabase() {


    abstract fun notesDao (): NotesDao
}