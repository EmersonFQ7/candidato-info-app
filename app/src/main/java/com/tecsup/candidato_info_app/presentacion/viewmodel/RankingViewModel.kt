package com.tecsup.candidato_info_app.presentacion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.candidato_info_app.data.model.Candidato
import com.tecsup.candidato_info_app.data.repository.CandidateRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RankingViewModel(private val repository: CandidateRepository) : ViewModel() {

    private val _cargos = MutableStateFlow<List<String>>(emptyList())
    val cargos: StateFlow<List<String>> = _cargos

    private val _selectedCargo = MutableStateFlow("Presidente de la República")
    val selectedCargo: StateFlow<String> = _selectedCargo

    private val _ranking = MutableStateFlow<List<Pair<Candidato, Int>>>(emptyList())
    val ranking: StateFlow<List<Pair<Candidato, Int>>> = _ranking

    init {
        loadCargos()
        loadRanking()
    }

    private fun loadCargos() {
        viewModelScope.launch {
            _cargos.value = listOf(
                "Presidente de la República",
                "Congresista",
                "Alcalde",
                "Gobernador"
            )
        }
    }

    fun selectCargo(cargo: String) {
        _selectedCargo.value = cargo
        loadRanking()
    }

    private fun loadRanking() {
        viewModelScope.launch {
            _ranking.value = repository.obtenerRankingPorCargo(_selectedCargo.value)
        }
    }
}