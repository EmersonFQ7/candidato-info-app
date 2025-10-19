package com.tecsup.candidato_info_app

import androidx.navigation.compose.rememberNavController
// Tus imports deben incluir:

import android.os.Bundle // Para el Bundle en onCreate
import androidx.activity.ComponentActivity // Para extender ComponentActivity
import androidx.activity.compose.setContent // Para usar el setContent
import androidx.navigation.compose.rememberNavController // ¡MUY IMPORTANTE para rememberNavController!

// La importación de tu NavHost y Tema
import com.tecsup.candidato_info_app.navigation.AppNavHost
import com.tecsup.candidato_info_app.ui.theme.CandidatoinfoappTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CandidatoinfoappTheme { // Tu tema
                val navController = rememberNavController()
                AppNavHost(navController = navController) // Usar el NavHost
            }
        }
    }
}