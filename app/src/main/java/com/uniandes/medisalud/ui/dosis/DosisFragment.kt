package com.uniandes.medisalud.ui.dosis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.uniandes.medisalud.databinding.FragmentDosisBinding

class DosisFragment : Fragment() {

    private var _binding: FragmentDosisBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dosisViewModel =
            ViewModelProvider(this).get(DosisViewModel::class.java)

        _binding = FragmentDosisBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.titleDosis
        dosisViewModel.text.observe(viewLifecycleOwner) {
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}