package com.tecsup.candidato_info_app.model

data class Candidato(
    val id: Int,
    val nombre: String,
    val partido: String,
    val cargo: String,
    val fotoUrl: String,
    val biografia: String,
    val denuncias: List<Denuncia> = emptyList()
)
