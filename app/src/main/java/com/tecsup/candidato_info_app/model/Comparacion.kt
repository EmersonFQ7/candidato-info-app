package com.tecsup.candidato_info_app.model

data class Comparacion(
    val candidato1: Candidato,
    val candidato2: Candidato,
    val diferencias: String
)
