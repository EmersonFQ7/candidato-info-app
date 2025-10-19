package com.tecsup.candidato_info_app.presentacion.screens

// presentacion/screens/CandidateDetailScreen.kt

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CandidateDetailScreen(candidateId: String) {
    // Muestra el ID recibido como argumento de navegación
    Text(text = "Detalle del Candidato ID: $candidateId")
}