// CandidateRepository.kt
package com.tecsup.candidato_info_app.data

import com.tecsup.candidato_info_app.R
import com.tecsup.candidato_info_app.data.model.*

object CandidateRepository {

    val candidates = listOf(
        Candidate(
            id = "1",
            name = "María López Vargas",
            party = "Partido Nacional Progreso",
            position = "Candidato al Congreso",
            location = "Lima",
            photoUrl = "",
            biography = "Abogada especializada en derecho constitucional.",
            imagenRes = R.drawable.ic_launcher_background,
            projects = listOf(
                Project("P1","Reforma educativa","Mejorar la calidad educativa","En proceso")
            ),
            politicalHistory = listOf(
                PoliticalPosition("Regidora","Municipalidad de Lima",2019,2022)
            ),
            investigations = listOf(),
            denunciations = listOf()
        ),
        Candidate(
            id = "2",
            name = "Carlos Méndez Huamán",
            party = "Movimiento Esperanza Ciudadana",
            position = "Candidato a la Presidencia",
            location = "Cusco",
            photoUrl = "",
            biography = "Economista con amplia experiencia en desarrollo regional.",
            imagenRes = R.drawable.ic_launcher_background,
            projects = listOf(
                Project("P2","Plan de desarrollo rural","Infraestructura agrícola","Aprobado")
            ),
            politicalHistory = listOf(
                PoliticalPosition("Gobernador Regional","Cusco",2018,2022)
            ),
            investigations = listOf(),
            denunciations = listOf()
        )
        // Agrega más candidatos aquí...
    )

    fun searchCandidates(query: String): List<Candidate> {
        return candidates.filter {
            it.name.contains(query, ignoreCase = true) ||
                    it.party.contains(query, ignoreCase = true) ||
                    it.location.contains(query, ignoreCase = true)
        }
    }

    fun getCandidateById(id: String): Candidate? {
        return candidates.find { it.id == id }
    }
}
