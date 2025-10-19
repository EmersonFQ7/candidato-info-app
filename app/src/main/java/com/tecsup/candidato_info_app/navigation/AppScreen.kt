package com.tecsup.candidato_info_app.navigation

sealed class AppScreen(val route: String) {
    object Home : AppScreen("home")

    // Necesitamos pasar el ID del candidato a la pantalla de detalle
    object CandidateDetail : AppScreen("candidate_detail/{candidateId}") {
        fun createRoute(candidateId: String) = "candidate_detail/$candidateId"
    }

    object Comparison : AppScreen("comparison")
}