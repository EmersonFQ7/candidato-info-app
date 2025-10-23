package com.tecsup.candidato_info_app.presentacion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tecsup.candidato_info_app.data.model.Noticia
import com.tecsup.candidato_info_app.data.repository.CandidateRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val repository = CandidateRepository()

    private val _noticias = MutableStateFlow<List<Noticia>>(emptyList())
    val noticias: StateFlow<List<Noticia>> = _noticias

    private val _selectedNoticia = MutableStateFlow<Noticia?>(null)
    val selectedNoticia: StateFlow<Noticia?> = _selectedNoticia

    init {
        loadNoticias()
    }

    private fun loadNoticias() {
        try {
            _noticias.value = repository.getNoticias()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun selectNoticia(noticia: Noticia) {
        _selectedNoticia.value = noticia
    }
}
