package com.uniandes.medisalud.ui.escalas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.uniandes.medisalud.databinding.FragmentEscalasBinding
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.uniandes.medisalud.R

class EscalasFragment : Fragment() {

    private var _binding: FragmentEscalasBinding? = null
    private lateinit var navController: NavController

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val escalasViewModel =
            ViewModelProvider(this).get(EscalasViewModel::class.java)

        _binding = FragmentEscalasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.titleEscalas
        escalasViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonGlasgow.setOnClickListener {
            val navController = findNavController()
            navController.navigate(R.id.nav_dosis)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}

