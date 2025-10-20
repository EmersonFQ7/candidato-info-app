package com.tecsup.candidato_info_app.data.model

data class Candidate(
    val id: String,
    val name: String,
    val party: String,
    val position: String,
    val location: String,
    val photoUrl: String,
    val biography: String,
    val projects: List<Project> = emptyList(),
    val politicalHistory: List<PoliticalPosition> = emptyList(),
    val investigations: List<Investigation> = emptyList(),
    val denunciations: List<Denunciation> = emptyList()
)

data class Project(
    val id: String,
    val title: String,
    val description: String,
    val status: String
)

data class PoliticalPosition(
    val position: String,
    val organization: String,
    val startYear: Int,
    val endYear: Int?
)

data class Investigation(
    val id: String,
    val title: String,
    val status: String,
    val date: String
)

data class Denunciation(
    val id: String,
    val title: String,
    val status: String,
    val date: String
)