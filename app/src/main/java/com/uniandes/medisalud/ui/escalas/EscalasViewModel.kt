package com.uniandes.medisalud.ui.escalas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EscalasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Tipos de escalas"
    }
    val text: LiveData<String> = _text
}