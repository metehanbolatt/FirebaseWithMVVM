package com.metehanbolat.firebasewithmvvm.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.metehanbolat.firebasewithmvvm.R
import com.metehanbolat.firebasewithmvvm.databinding.FragmentNoteListingBinding

class NoteListingFragment : Fragment() {

    val TAG: String = "NoteListingFragment"

    private var _binding: FragmentNoteListingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteListingBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}