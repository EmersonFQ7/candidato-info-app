package com.tecsup.candidato_info_app.presentacion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.candidato_info_app.data.model.Candidato
import com.tecsup.candidato_info_app.data.repository.CandidateRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CandidateViewModel : ViewModel() {

    private val repository = CandidateRepository()

    private val _candidato = MutableStateFlow<Candidato?>(null)
    val candidato: StateFlow<Candidato?> = _candidato

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun getCandidatoById(id: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _candidato.value = repository.getCandidatoById(id)
            _isLoading.value = false
        }
    }
}