package com.example.nevigationdrawer.db.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.nevigationdrawer.db.entiteis.NotesEntity

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