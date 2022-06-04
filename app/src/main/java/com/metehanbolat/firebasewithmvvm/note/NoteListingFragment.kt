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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListingFragment : Fragment() {

    val TAG: String = "NoteListingFragment"

    private var _binding: FragmentNoteListingBinding? = null
    private val binding get() = _binding!!

    val viewModel: NoteViewModel by viewModels()

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

        viewModel.note.observe(viewLifecycleOwner) { noteList ->
            noteList.forEach { note ->
                Log.e(TAG, note.toString())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}