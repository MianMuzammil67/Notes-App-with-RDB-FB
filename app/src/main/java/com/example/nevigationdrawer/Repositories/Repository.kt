package com.example.nevigationdrawer.Repositories

import com.example.nevigationdrawer.db.entiteis.NotesEntity
import com.example.nevigationdrawer.db.NotesRdbDataBase

class Repository(private val db: NotesRdbDataBase) {


    suspend fun insertN0tes(entity: NotesEntity) = db.notesDao().insertRdbNotes(entity)
    suspend fun updateN0tes(entity: NotesEntity) = db.notesDao().updateRdbNOtes(entity)
    suspend fun deleteN0tes(entity: NotesEntity) = db.notesDao().deleteRdbNotes(entity)
    fun getNOtes() = db.notesDao().getRdbNotes()

}