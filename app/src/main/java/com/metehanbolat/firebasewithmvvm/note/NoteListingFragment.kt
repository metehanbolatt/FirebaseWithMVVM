package com.metehanbolat.firebasewithmvvm.note

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.metehanbolat.firebasewithmvvm.R
import com.metehanbolat.firebasewithmvvm.databinding.FragmentNoteListingBinding
import com.metehanbolat.firebasewithmvvm.util.UiState
import com.metehanbolat.firebasewithmvvm.util.hide
import com.metehanbolat.firebasewithmvvm.util.show
import com.metehanbolat.firebasewithmvvm.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListingFragment : Fragment() {

    val TAG: String = "NoteListingFragment"

    private var _binding: FragmentNoteListingBinding? = null
    private val binding get() = _binding!!

    val viewModel: NoteViewModel by viewModels()
    val adapter by lazy {
        NoteListingAdapter(
            onItemClicked = { position, item ->

            },
            onEditClicked = { position, item ->

            },
            onDeleteClicked = { position, item ->

            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteListingBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel.getNotes()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter

        viewModel.note.observe(viewLifecycleOwner) { noteListState ->
            when(noteListState) {
                is UiState.Loading -> {
                    binding.progressBar.show()
                }
                is UiState.Success -> {
                    binding.progressBar.hide()
                    adapter.updateList(noteListState.data.toMutableList())
                }
                is UiState.Failure -> {
                    binding.progressBar.hide()
                    toast(noteListState.error)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}