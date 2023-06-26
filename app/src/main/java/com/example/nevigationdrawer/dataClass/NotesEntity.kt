package com.example.nevigationdrawer.dataClass

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NOTES_db")
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val tittle: String,
    val notes: String
)
