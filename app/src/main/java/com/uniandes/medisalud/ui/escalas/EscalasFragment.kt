package com.uniandes.medisalud.ui.escalas

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.uniandes.medisalud.databinding.FragmentEscalasBinding
import androidx.navigation.NavController
import android.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.uniandes.medisalud.R

class EscalasFragment : Fragment(){

    private var _binding: FragmentEscalasBinding? = null
    private lateinit var navController: NavController

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var score = 0
    private var indicePregunta = 0
    private var selectedAns = ""

    companion object {
        val preguntas = arrayOf("Tipos de escalas","Abertura ocular", "Respuesta verbal", "Respuesta motora")
        val opciones = arrayOf(
            arrayOf("Escala de Glasgow", "Escala de Ramsay", "Escala de Alvarado", "Escala de Fisher", "Escala de ECOG", "Escala de Norton"),
            arrayOf("Espontánea", "Al estímulo verbal", "Al estímulo doloroso", "Ausente"),
            arrayOf("Orientada", "Confusa", "Palabras inapropiadas", "Sonidos incomprensibles", "Ausente"),
            arrayOf("Obedece órdenes", "Localiza el estímulo doloroso", "Retira el estímulo doloroso", "Flexión anormal", "Extensión anormal", "Ausente")
        )
    }

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
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ansA.setOnClickListener {
            selectedAns = binding.ansA.text.toString()
            binding.ansA.setBackgroundColor(Color.CYAN)
            binding.ansB.setBackgroundColor(Color.WHITE)
            binding.ansC.setBackgroundColor(Color.WHITE)
            binding.ansD.setBackgroundColor(Color.WHITE)
            binding.ansE.setBackgroundColor(Color.WHITE)
            binding.ansF.setBackgroundColor(Color.WHITE)
        }
        binding.ansB.setOnClickListener {
            selectedAns = binding.ansB.text.toString()
            binding.ansA.setBackgroundColor(Color.WHITE)
            binding.ansB.setBackgroundColor(Color.CYAN)
            binding.ansC.setBackgroundColor(Color.WHITE)
            binding.ansD.setBackgroundColor(Color.WHITE)
            binding.ansE.setBackgroundColor(Color.WHITE)
            binding.ansF.setBackgroundColor(Color.WHITE)
        }
        binding.ansC.setOnClickListener {
            selectedAns = binding.ansC.text.toString()
            binding.ansA.setBackgroundColor(Color.WHITE)
            binding.ansB.setBackgroundColor(Color.WHITE)
            binding.ansC.setBackgroundColor(Color.CYAN)
            binding.ansD.setBackgroundColor(Color.WHITE)
            binding.ansE.setBackgroundColor(Color.WHITE)
            binding.ansF.setBackgroundColor(Color.WHITE)
        }
        binding.ansD.setOnClickListener {
            selectedAns = binding.ansD.text.toString()
            binding.ansA.setBackgroundColor(Color.WHITE)
            binding.ansB.setBackgroundColor(Color.WHITE)
            binding.ansC.setBackgroundColor(Color.WHITE)
            binding.ansD.setBackgroundColor(Color.CYAN)
            binding.ansE.setBackgroundColor(Color.WHITE)
            binding.ansF.setBackgroundColor(Color.WHITE)
        }
        binding.ansE.setOnClickListener {
            selectedAns = binding.ansE.text.toString()
            binding.ansA.setBackgroundColor(Color.WHITE)
            binding.ansB.setBackgroundColor(Color.WHITE)
            binding.ansC.setBackgroundColor(Color.WHITE)
            binding.ansD.setBackgroundColor(Color.WHITE)
            binding.ansE.setBackgroundColor(Color.CYAN)
            binding.ansF.setBackgroundColor(Color.WHITE)
        }
        binding.ansF.setOnClickListener {
            selectedAns = binding.ansF.text.toString()
            binding.ansA.setBackgroundColor(Color.WHITE)
            binding.ansB.setBackgroundColor(Color.WHITE)
            binding.ansC.setBackgroundColor(Color.WHITE)
            binding.ansD.setBackgroundColor(Color.WHITE)
            binding.ansE.setBackgroundColor(Color.WHITE)
            binding.ansF.setBackgroundColor(Color.CYAN)
        }

        binding.buttonSubmit.setOnClickListener {
            binding.ansA.setBackgroundColor(Color.WHITE)
            binding.ansB.setBackgroundColor(Color.WHITE)
            binding.ansC.setBackgroundColor(Color.WHITE)
            binding.ansD.setBackgroundColor(Color.WHITE)
            binding.ansE.setBackgroundColor(Color.WHITE)
            binding.ansF.setBackgroundColor(Color.WHITE)

            binding.titleEscalas.setText(preguntas[indicePregunta])

            if (indicePregunta == 1) {
                if (opciones[indicePregunta][0] == selectedAns) {
                    score += 4
                } else if (opciones[indicePregunta][1] == selectedAns) {
                    score += 3
                } else if (opciones[indicePregunta][2] == selectedAns) {
                    score += 2
                } else if (opciones[indicePregunta][3] == selectedAns) {
                    score += 1
                } else {
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("Error")
                    builder.setMessage("Seleccione una opción")
                    builder.setPositiveButton("Aceptar") { dialog, which ->
                        dialog.dismiss()
                    }
                    val alertDialog: AlertDialog = builder.create()
                    alertDialog.show()
                    indicePregunta--
                }
            } else if (indicePregunta == 2) {
                if (opciones[indicePregunta][0] == selectedAns) {
                    score += 5
                } else if (opciones[indicePregunta][1] == selectedAns) {
                    score += 4
                } else if (opciones[indicePregunta][2] == selectedAns) {
                    score += 3
                } else if (opciones[indicePregunta][3] == selectedAns) {
                    score += 2
                } else if (opciones[indicePregunta][4] == selectedAns) {
                    score += 1
                } else {
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("Error")
                    builder.setMessage("Seleccione una opción")
                    builder.setPositiveButton("Aceptar") { dialog, which ->
                        dialog.dismiss()
                    }
                    val alertDialog: AlertDialog = builder.create()
                    alertDialog.show()
                    indicePregunta--
                }
            } else if (indicePregunta == 3) {
                if (opciones[indicePregunta][0] == selectedAns) {
                    score += 6
                } else if (opciones[indicePregunta][1] == selectedAns) {
                    score += 5
                } else if (opciones[indicePregunta][2] == selectedAns) {
                    score += 4
                } else if (opciones[indicePregunta][3] == selectedAns) {
                    score += 3
                } else if (opciones[indicePregunta][4] == selectedAns) {
                    score += 2
                } else if (opciones[indicePregunta][5] == selectedAns) {
                    score += 1
                } else {
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("Error")
                    builder.setMessage("Seleccione una opción")
                    builder.setPositiveButton("Aceptar") { dialog, which ->
                        dialog.dismiss()
                    }
                    val alertDialog: AlertDialog = builder.create()
                    alertDialog.show()
                    indicePregunta--
                }
            }

            indicePregunta++

            if(indicePregunta == 4) {
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Escala de Glasgow")
                builder.setMessage("El resultado de la escala de Glasgow es: $score")
                builder.setPositiveButton("Aceptar") { dialog, which ->
                    score = 0
                    indicePregunta = 0
                    cargarPregunta()
                }
                val alertDialog: AlertDialog = builder.create()
                alertDialog.show()
            }

            if (indicePregunta == 1 && selectedAns != opciones[indicePregunta-1][0]) {
                indicePregunta--
            } else {
                cargarPregunta()
            }
        }

    }

    fun cargarPregunta() {

        if (indicePregunta == 0) {
            binding.titleEscalas.setText(preguntas[indicePregunta])
            binding.ansA.setText(opciones[indicePregunta][0])
            binding.ansB.setText(opciones[indicePregunta][1])
            binding.ansC.setText(opciones[indicePregunta][2])
            binding.ansD.setText(opciones[indicePregunta][3])
            binding.ansE.setText(opciones[indicePregunta][4])
            binding.ansF.setText(opciones[indicePregunta][5])
        } else if (indicePregunta == 1) {
            binding.titleEscalas.setText(preguntas[indicePregunta])
            binding.ansA.isVisible = false
            binding.ansB.setText(opciones[indicePregunta][0])
            binding.ansC.setText(opciones[indicePregunta][1])
            binding.ansD.setText(opciones[indicePregunta][2])
            binding.ansE.setText(opciones[indicePregunta][3])
            binding.ansF.isVisible = false
        } else if (indicePregunta == 2) {
            binding.titleEscalas.setText(preguntas[indicePregunta])
            binding.ansA.isVisible = true
            binding.ansA.setText(opciones[indicePregunta][0])
            binding.ansB.setText(opciones[indicePregunta][1])
            binding.ansC.setText(opciones[indicePregunta][2])
            binding.ansD.setText(opciones[indicePregunta][3])
            binding.ansE.setText(opciones[indicePregunta][4])
            binding.ansF.isVisible = false
        } else if (indicePregunta == 3) {
            binding.titleEscalas.setText(preguntas[indicePregunta])
            binding.ansA.setText(opciones[indicePregunta][0])
            binding.ansB.setText(opciones[indicePregunta][1])
            binding.ansC.setText(opciones[indicePregunta][2])
            binding.ansD.setText(opciones[indicePregunta][3])
            binding.ansE.setText(opciones[indicePregunta][4])
            binding.ansF.isVisible = true
            binding.ansF.setText(opciones[indicePregunta][5])
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}

