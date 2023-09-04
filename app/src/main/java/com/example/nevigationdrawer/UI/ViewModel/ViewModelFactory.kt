package com.example.nevigationdrawer.UI.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nevigationdrawer.Repositories.Repository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: Repository) : ViewModelProvider.NewInstanceFactory()  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RdbViewModel(repository) as T
    }
}