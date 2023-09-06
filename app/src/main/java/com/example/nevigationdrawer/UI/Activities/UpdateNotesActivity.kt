package com.example.nevigationdrawer.UI.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.nevigationdrawer.Repositories.Repository
import com.example.nevigationdrawer.UI.ViewModel.RdbViewModel
import com.example.nevigationdrawer.UI.ViewModel.ViewModelFactory
import com.example.nevigationdrawer.databinding.ActivityUpdateNotesBinding
import com.example.nevigationdrawer.db.NotesRdbDataBase
import com.example.nevigationdrawer.db.entiteis.NotesEntity

class UpdateNotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateNotesBinding
    private lateinit var notesDatabase: NotesRdbDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        notesDatabase = NotesRdbDataBase.getDatabase(this)
        val repository = Repository(notesDatabase)
        val factory = ViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,factory)[RdbViewModel::class.java]

        val notesTittle = intent.getStringExtra("TITTLE")
        val notesBody = intent.getStringExtra("NOTES")
        val notesId = intent.getIntExtra("ID",0)
        binding.etTittl.setText(notesTittle.toString())
        binding.etNotes.setText(notesBody.toString())

        binding.btnUpdateNotes.setOnClickListener{
            val tittle  = binding.etTittl.text.toString()
            val notes  = binding.etNotes.text.toString()
            viewModel.updateNotes(NotesEntity(notesId.toLong(),tittle,notes))
            Toast.makeText(this, "Note updated Successfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}