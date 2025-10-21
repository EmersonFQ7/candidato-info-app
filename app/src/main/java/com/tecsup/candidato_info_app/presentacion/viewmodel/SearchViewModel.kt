package com.tecsup.candidato_info_app.presentacion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.candidato_info_app.data.model.Candidato
import com.tecsup.candidato_info_app.data.repository.CandidateRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val repository = CandidateRepository()

    private val _candidatos = MutableStateFlow<List<Candidato>>(emptyList())
    val candidatos: StateFlow<List<Candidato>> = _candidatos

    private val _cargos = MutableStateFlow<List<String>>(emptyList())
    val cargos: StateFlow<List<String>> = _cargos

    private val _partidos = MutableStateFlow<List<String>>(emptyList())
    val partidos: StateFlow<List<String>> = _partidos

    private val _regiones = MutableStateFlow<List<String>>(emptyList())
    val regiones: StateFlow<List<String>> = _regiones

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _selectedCargo = MutableStateFlow("")
    val selectedCargo: StateFlow<String> = _selectedCargo

    private val _selectedPartido = MutableStateFlow("")
    val selectedPartido: StateFlow<String> = _selectedPartido

    private val _selectedRegion = MutableStateFlow("")
    val selectedRegion: StateFlow<String> = _selectedRegion

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        loadFilters()
        loadCandidatos()
    }

    private fun loadFilters() {
        viewModelScope.launch {
            _cargos.value = repository.getCargos()
            _partidos.value = repository.getPartidos()
            _regiones.value = repository.getRegiones()
        }
    }

    fun loadCandidatos() {
        viewModelScope.launch {
            _isLoading.value = true
            _candidatos.value = repository.searchCandidatos(
                query = _searchQuery.value,
                cargo = _selectedCargo.value,
                partido = _selectedPartido.value,
                region = _selectedRegion.value
            )
            _isLoading.value = false
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        loadCandidatos()
    }

    fun updateCargo(cargo: String) {
        _selectedCargo.value = cargo
        loadCandidatos()
    }

    fun updatePartido(partido: String) {
        _selectedPartido.value = partido
        loadCandidatos()
    }

    fun updateRegion(region: String) {
        _selectedRegion.value = region
        loadCandidatos()
    }


    fun clearFilters() {
        _searchQuery.value = ""
        _selectedCargo.value = ""
        _selectedPartido.value = ""
        _selectedRegion.value = ""
        loadCandidatos()
    }
}
