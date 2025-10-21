package com.tecsup.candidato_info_app.data.model

data class Denuncia(
    val id: String,
    val tipo: String, // "Investigación", "Denuncia"
    val titulo: String,
    val descripcion: String,
    val fecha: String,
    val estado: String, // "En proceso", "Archivada", "Resuelta"
    val institucion: String
)