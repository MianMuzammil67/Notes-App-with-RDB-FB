package com.example.nevigationdrawer.UI.ViewModel

import androidx.lifecycle.ViewModel
import com.example.nevigationdrawer.Repositories.Repository
import com.example.nevigationdrawer.db.entiteis.NotesEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RdbViewModel(private val repository: Repository): ViewModel() {
    fun insertNotes(entity: NotesEntity)= CoroutineScope(Dispatchers.Main).launch { repository.insertN0tes(entity) }
    fun updateNotes(entity: NotesEntity)= CoroutineScope(Dispatchers.Main).launch { repository.updateN0tes(entity) }
    fun deleteNotes(entity: NotesEntity)= CoroutineScope(Dispatchers.Main).launch { repository.deleteN0tes(entity) }
    fun getNotes()=repository.getNOtes()


}