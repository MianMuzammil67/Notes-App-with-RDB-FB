package com.example.nevigationdrawer.UI.Activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.nevigationdrawer.Repositories.Repository
import com.example.nevigationdrawer.UI.Adapter.RecyclerViewAdapter
import com.example.nevigationdrawer.UI.ViewModel.RdbViewModel
import com.example.nevigationdrawer.UI.ViewModel.ViewModelFactory
import com.example.nevigationdrawer.databinding.ActivityMainBinding
import com.example.nevigationdrawer.db.NotesRdbDataBase

class MainActivity : AppCompatActivity() {
    private lateinit var rdbDatabase: NotesRdbDataBase
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
//        supportActionBar?.setBackgroundDrawable(ColorDrawable( resources.getColor(R.color.yellow)))
//        supportActionBar?.title = "My Notes"


        rdbDatabase = NotesRdbDataBase.getDatabase(this)
        val repository = Repository(rdbDatabase)
        val factory = ViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory)[RdbViewModel::class.java]

        val adapter = RecyclerViewAdapter(this, viewModel,listOf())
        binding.rvMain.layoutManager=StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        binding.rvMain.adapter= adapter
        viewModel.getNotes().observe(this) {
            adapter.list = it
            adapter.notifyDataSetChanged()
        }

        binding.btNewNotes.setOnClickListener {
            val intent = Intent(this, NewNotesActivity::class.java)
            startActivity(intent)
        }

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // This method is called before the text is changed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // This method is called when the text is changed
                val searchText = s.toString()
                viewModel.searchNotes(searchText).observe(this@MainActivity){
                    adapter.list = it
                    adapter.notifyDataSetChanged()
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // This method is called after the text has changed
                val searchText = s.toString()

                viewModel.searchNotes("%$searchText%").observe(this@MainActivity){
                    adapter.list = it
                    adapter.notifyDataSetChanged()
                }
            }
        })
//        binding.etSearch.setOnEditorActionListener(object : TextView.OnEditorActionListener {
//            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
//                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                    viewModel.searchNotes()
//                    return true
//                }
//                return false
//            }
//        })


    }
}