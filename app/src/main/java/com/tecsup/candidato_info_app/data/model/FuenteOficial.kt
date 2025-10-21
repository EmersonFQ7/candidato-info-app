package com.tecsup.candidato_info_app.data.model

data class FuenteOficial(
    val id: String,
    val nombre: String,
    val url: String,
    val tipo: String, // "ONPE", "Congreso", "Poder Judicial"
    val descripcion: String
)