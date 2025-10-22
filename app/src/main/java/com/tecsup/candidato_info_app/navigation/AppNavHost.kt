package com.tecsup.candidato_info_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tecsup.candidato_info_app.presentacion.screens.HomeScreen
import com.tecsup.candidato_info_app.presentacion.screens.CandidateSearchScreen
import com.tecsup.candidato_info_app.presentacion.screens.CandidateDetailScreen
import com.tecsup.candidato_info_app.presentacion.screens.ComparisonScreen
import com.tecsup.candidato_info_app.presentacion.screens.OfficialSourcesScreen
import com.tecsup.candidato_info_app.presentacion.screens.SplashScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppScreen.Splash.route) {

        composable(AppScreen.Splash.route) {
            SplashScreen(navController)
        }

        composable(AppScreen.Home.route) {
            HomeScreen(navController)
        }

        composable(AppScreen.CandidateSearch.route) {
            CandidateSearchScreen(navController)
        }

        composable(AppScreen.CandidateDetail.route) { backStackEntry ->
            val candidateId = backStackEntry.arguments?.getString("candidateId") ?: ""
            CandidateDetailScreen(navController, candidateId)
        }

        composable(AppScreen.Comparison.route) {
            ComparisonScreen(navController)
        }

        composable(AppScreen.OfficialSources.route) {
            OfficialSourcesScreen(navController)
        }
    }
}
