package com.tecsup.candidato_info_app.data.model

data class Voto(
    val id: String,
    val candidatoId: String,
    val timestamp: Long,
    val cargo: String
)