package com.example.nevigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nevigationdrawer.dataClass.NotesEntity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var rdbDatabase: NotesRdbDataBase
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rdbDatabase = NotesRdbDataBase.getDatabase(this)
        GlobalScope.launch{
            rdbDatabase.notesDao().insertRdbNotes(NotesEntity(0,"tittle","notes"))
            rdbDatabase.notesDao().insertRdbNotes(NotesEntity(0,"tittle5","notesHGGF"))
        }



    }
}