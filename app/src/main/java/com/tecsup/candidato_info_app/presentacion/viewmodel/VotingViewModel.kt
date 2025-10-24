package com.tecsup.candidato_info_app.presentacion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.candidato_info_app.data.repository.CandidateRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VotingViewModel(private val repository: CandidateRepository) : ViewModel() {

    private val _votosRegistrados = MutableStateFlow<Set<String>>(emptySet())
    val votosRegistrados: StateFlow<Set<String>> = _votosRegistrados

    private val _showVotingConfirmation = MutableStateFlow(false)
    val showVotingConfirmation: StateFlow<Boolean> = _showVotingConfirmation

    private val _selectedCandidatoId = MutableStateFlow<String?>(null)
    val selectedCandidatoId: StateFlow<String?> = _selectedCandidatoId

    fun registrarVoto(candidatoId: String) {
        viewModelScope.launch {
            repository.registrarVoto(candidatoId)
            _votosRegistrados.value = _votosRegistrados.value + candidatoId
        }
    }

    fun mostrarConfirmacion(candidatoId: String) {
        _selectedCandidatoId.value = candidatoId
        _showVotingConfirmation.value = true
    }

    fun cerrarConfirmacion() {
        _showVotingConfirmation.value = false
        _selectedCandidatoId.value = null
    }

    fun yaVoto(candidatoId: String): Boolean {
        return _votosRegistrados.value.contains(candidatoId)
    }
}