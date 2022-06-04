package com.metehanbolat.firebasewithmvvm.note

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.metehanbolat.firebasewithmvvm.data.model.Note
import com.metehanbolat.firebasewithmvvm.databinding.ItemNoteLayoutBinding
import com.metehanbolat.firebasewithmvvm.util.addChip
import com.metehanbolat.firebasewithmvvm.util.hide
import java.text.SimpleDateFormat

class NoteListingAdapter(
    val onItemClicked: (Int, Note) -> Unit,
    val onEditClicked: (Int, Note) -> Unit,
    val onDeleteClicked: (Int, Note) -> Unit,
) : RecyclerView.Adapter<NoteListingAdapter.MyViewHolder>() {

    @SuppressLint("SimpleDateFormat")
    val sdf = SimpleDateFormat("dd MMM yyyy")
    private var list: MutableList<Note> = arrayListOf()

    inner class MyViewHolder(val binding: ItemNoteLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Note) {
            binding.apply {
                title.text = item.title
                date.text = sdf.format(item.date)
                tags.apply {
                    if (item.tags.isEmpty()) {
                        hide()
                    } else {
                        removeAllViews()
                        if (item.tags.size > 2) {
                            item.tags.subList(0, 2).forEach { tag -> addChip(tag) }
                            addChip("+${item.tags.size - 2}")
                        } else {
                            item.tags.forEach { tag -> addChip(tag) }
                        }
                    }
                }
                desc.apply {
                    text = if (item.description.length > 120) {
                        "${item.description.substring(0, 120)}..."
                    } else {
                        item.description
                    }
                }
                itemLayout.setOnClickListener {
                    onItemClicked.invoke(
                        adapterPosition,
                        item
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteListingAdapter.MyViewHolder {
        val itemView =
            ItemNoteLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteListingAdapter.MyViewHolder, position: Int) {
        val item = list[position]
    }

    fun updateList(list: MutableList<Note>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        list.removeAt(position)
        notifyItemChanged(position)
    }

    override fun getItemCount() = list.size

}