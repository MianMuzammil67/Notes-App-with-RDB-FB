package com.example.nevigationdrawer.UI.Adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nevigationdrawer.UI.Activities.UpdateNotesActivity
import com.example.nevigationdrawer.UI.ViewModel.RdbViewModel
import com.example.nevigationdrawer.databinding.MainRvSampleBinding
import com.example.nevigationdrawer.db.entiteis.NotesEntity

class RecyclerViewAdapter(
    private val context: Context,
    private val viewModel: RdbViewModel,
    var list: List<NotesEntity>
) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            MainRvSampleBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote = list[position]
        holder.binding.tvTittle.text = currentNote.tittle
        holder.binding.tvNotes.text = currentNote.notes

        holder.itemView.setOnClickListener {
            val intent = Intent(context, UpdateNotesActivity::class.java)
            intent.putExtra("TITTLE", currentNote.tittle)
            intent.putExtra("ID", position + 1)
            intent.putExtra("NOTES", currentNote.notes)
            context.startActivity(intent)
        }
        holder.itemView.setOnLongClickListener {

            val deleteDialog = AlertDialog.Builder(context)
            deleteDialog.setMessage(" Are you sure you want to Delete?")
            deleteDialog.setPositiveButton("yes"){dialog,id ->
                viewModel.deleteNotes(currentNote)
            }
            deleteDialog.setNegativeButton("No"){dialog,id->
                dialog.cancel()
            }
            deleteDialog.show()
            true
        }
    }

    class ViewHolder(val binding: MainRvSampleBinding) :
        RecyclerView.ViewHolder(binding.root)


}