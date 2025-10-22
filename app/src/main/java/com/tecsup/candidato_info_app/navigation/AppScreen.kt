package com.tecsup.candidato_info_app.navigation

sealed class AppScreen(val route: String) {
    object Splash : AppScreen("splash")

    object Home : AppScreen("home")
    object CandidateSearch : AppScreen("candidate_search")
    object CandidateDetail : AppScreen("candidate_detail/{candidateId}") {
        fun createRoute(candidateId: String) = "candidate_detail/$candidateId"
    }
    object Comparison : AppScreen("comparison")
    object OfficialSources : AppScreen("official_sources")
}
