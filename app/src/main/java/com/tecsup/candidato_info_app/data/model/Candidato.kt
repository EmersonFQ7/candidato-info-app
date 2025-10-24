package com.tecsup.candidato_info_app.data.model

data class Candidato(
    val id: String,
    val nombre: String,
    val cargo: String,
    val partido: String,
    val region: String,
    val ciudad: String,
    val fotoUrl: String,
    val imagenRes: Int? = null,
    val descripcion: String,
    val proyectos: List<Proyecto>,
    val historialPolitico: List<HistorialPolitico>,
    val denuncias: List<Denuncia>,
    val fuentesOficiales: List<FuenteOficial>,
    val tieneInvestigaciones: Boolean,
    val tieneDenuncias: Boolean
)
