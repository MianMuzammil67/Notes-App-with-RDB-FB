package com.example.nevigationdrawer.UI.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.nevigationdrawer.Repositories.Repository
import com.example.nevigationdrawer.UI.ViewModel.RdbViewModel
import com.example.nevigationdrawer.UI.ViewModel.ViewModelFactory
import com.example.nevigationdrawer.db.entiteis.NotesEntity
import com.example.nevigationdrawer.databinding.ActivityNewNotesBinding
import com.example.nevigationdrawer.db.NotesRdbDataBase

class NewNotesActivity : AppCompatActivity() {
    private lateinit var binding :ActivityNewNotesBinding
    private lateinit var rdbDataBase: NotesRdbDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        rdbDataBase = NotesRdbDataBase.getDatabase(this)
        val repository = Repository(rdbDataBase)
        val factory = ViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[RdbViewModel::class.java]


        binding.btAdNotes.setOnClickListener {

            val tittle  = binding.etTittle.text.toString()
            val notes  = binding.etNotes.text.toString()
//            val subtitle = binding.etSubTittle.text.toString()
            if (tittle.isNotEmpty()&& notes.isNotEmpty()) {
                viewModel.insertNotes(NotesEntity(0, tittle, notes))
                Toast.makeText(this, "Note Added Successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Please Enter Something", Toast.LENGTH_SHORT).show()
            }

        }
    }
}