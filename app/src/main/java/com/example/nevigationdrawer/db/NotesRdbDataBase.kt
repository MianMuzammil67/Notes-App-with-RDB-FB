package com.example.nevigationdrawer.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nevigationdrawer.db.Dao.NotesDao
import com.example.nevigationdrawer.db.entiteis.NotesEntity

@Database(entities = [NotesEntity::class], version = 1)
abstract class NotesRdbDataBase : RoomDatabase() {
    abstract fun notesDao() : NotesDao
    companion object{
        @Volatile
        private var INSTANCE : NotesRdbDataBase? = null
        fun getDatabase(context:Context): NotesRdbDataBase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context,
                        NotesRdbDataBase::class.java,
                        "NOTES_db").build()
                }
            }
        return INSTANCE!!
        }
    }


}