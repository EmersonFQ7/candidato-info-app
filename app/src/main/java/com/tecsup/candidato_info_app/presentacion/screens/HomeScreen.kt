package com.tecsup.candidato_info_app.presentacion.screens

// presentacion/screens/HomeScreen.kt

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    // Funciones para navegar, definidas en AppNavHost.kt
    onNavigateToDetail: (candidateId: String) -> Unit,
    onNavigateToComparison: () -> Unit
) {
    // Código mínimo para probar la navegación
    Text(text = "Pantalla de Inicio")

    // Botón de prueba para ir a Detalle (simulando un click)
    Button(onClick = { onNavigateToDetail("ID_CANDIDATO_DEMO") }) {
        Text("Ir a Detalle")
    }

    // Botón de prueba para ir a Comparación
    Button(onClick = onNavigateToComparison) {
        Text("Ir a Comparar")
    }
}