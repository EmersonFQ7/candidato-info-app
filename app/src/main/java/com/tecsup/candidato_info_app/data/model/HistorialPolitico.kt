package com.tecsup.candidato_info_app.data.model

data class HistorialPolitico(
    val id: String,
    val cargo: String,
    val institucion: String,
    val fechaInicio: String,
    val fechaFin: String?,
    val descripcion: String
)