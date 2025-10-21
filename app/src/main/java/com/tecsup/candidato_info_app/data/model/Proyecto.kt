package com.tecsup.candidato_info_app.data.model

data class Proyecto(
    val id: String,
    val nombre: String,
    val descripcion: String,
    val estado: String, // "Plan", "En Proceso", "Completado"
    val fechaInicio: String,
    val fechaFin: String?
)