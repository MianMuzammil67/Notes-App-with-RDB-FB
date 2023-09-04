package com.example.nevigationdrawer.db.entiteis

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NOTES_db")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val tittle: String,
//    val subTittle: String,
    val notes: String
)
