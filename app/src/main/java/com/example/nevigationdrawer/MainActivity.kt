package com.example.nevigationdrawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nevigationdrawer.Activities.NewNotesActivity
import com.example.nevigationdrawer.dataClass.NotesEntity
import com.example.nevigationdrawer.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var rdbDatabase: NotesRdbDataBase
    private lateinit var binding : ActivityMainBinding
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        binding.btAdNotes.setOnClickListener{
            val intent = Intent(this,NewNotesActivity::class.java)
            startActivity(intent)
        }


        rdbDatabase = NotesRdbDataBase.getDatabase(this)
        GlobalScope.launch{
            rdbDatabase.notesDao().insertRdbNotes(NotesEntity(0,"tittle","notes"))
            rdbDatabase.notesDao().insertRdbNotes(NotesEntity(0,"tittle5","notesHGGF"))
        }





    }
}