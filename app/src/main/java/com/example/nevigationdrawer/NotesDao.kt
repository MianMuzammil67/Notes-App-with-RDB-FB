package com.example.nevigationdrawer

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.nevigationdrawer.dataClass.NotesEntity

@Dao
interface NotesDao {

    @Insert
    suspend fun insertRdbNotes(entity: NotesEntity)
    @Update
   suspend fun updateRdbNOtes(entity: NotesEntity)
    @Delete
   suspend fun deleteRdbNotes(entity: NotesEntity)

    @Query("SELECT * FROM NOTES_db")
    fun getRdbNotes() :LiveData<List<NotesEntity>>
}