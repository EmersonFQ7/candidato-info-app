package com.tecsup.candidato_info_app.presentacion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.candidato_info_app.data.model.Candidato
import com.tecsup.candidato_info_app.data.repository.CandidateRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ComparisonViewModel : ViewModel() {

    private val repository = CandidateRepository()

    private val _candidatos = MutableStateFlow<List<Candidato>>(emptyList())
    val candidatos: StateFlow<List<Candidato>> = _candidatos

    private val _selectedCandidato1 = MutableStateFlow<Candidato?>(null)
    val selectedCandidato1: StateFlow<Candidato?> = _selectedCandidato1

    private val _selectedCandidato2 = MutableStateFlow<Candidato?>(null)
    val selectedCandidato2: StateFlow<Candidato?> = _selectedCandidato2

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        loadCandidatos()
    }

    private fun loadCandidatos() {
        viewModelScope.launch {
            _isLoading.value = true
            _candidatos.value = repository.getAllCandidatos()
            _isLoading.value = false
        }
    }

    fun selectCandidato1(candidato: Candidato) {
        _selectedCandidato1.value = candidato
    }

    fun selectCandidato2(candidato: Candidato) {
        _selectedCandidato2.value = candidato
    }

    fun canCompare(): Boolean = _selectedCandidato1.value != null && _selectedCandidato2.value != null
}

