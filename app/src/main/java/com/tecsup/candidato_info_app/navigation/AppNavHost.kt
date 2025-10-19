package com.tecsup.candidato_info_app.navigation

import androidx.navigation.*
import androidx.navigation.compose.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.tecsup.candidato_info_app.presentacion.screens.HomeScreen
import com.tecsup.candidato_info_app.presentacion.screens.CandidateDetailScreen
import com.tecsup.candidato_info_app.presentacion.screens.ComparisonScreen
// ... (y las otras importaciones de screens)

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Home.route // El inicio de la app
    ) {
        // 1. HOME SCREEN
        composable(AppScreen.Home.route) {
            // Pasamos funciones lambda para navegar
            HomeScreen(
                onNavigateToDetail = { candidateId ->
                    navController.navigate(AppScreen.CandidateDetail.createRoute(candidateId))
                },
                onNavigateToComparison = {
                    navController.navigate(AppScreen.Comparison.route)
                }
            )
        }

        // 2. CANDIDATE DETAIL SCREEN
        composable(
            route = AppScreen.CandidateDetail.route,
            arguments = listOf(navArgument("candidateId") { type = NavType.StringType })
        ) { backStackEntry ->
            val candidateId = backStackEntry.arguments?.getString("candidateId") ?: "0"
            CandidateDetailScreen(candidateId = candidateId)
        }

        // 3. COMPARISON SCREEN
        composable(AppScreen.Comparison.route) {
            ComparisonScreen()
        }
    }
}