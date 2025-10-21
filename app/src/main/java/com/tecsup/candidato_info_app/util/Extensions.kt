package com.tecsup.candidato_info_app.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun getStatusColor(status: String): Color {
    return when {
        status.contains("Completado", ignoreCase = true) -> MaterialTheme.colorScheme.primary
        status.contains("En Proceso", ignoreCase = true) -> MaterialTheme.colorScheme.secondary
        status.contains("Plan", ignoreCase = true) -> MaterialTheme.colorScheme.tertiary
        status.contains("Archivada", ignoreCase = true) -> MaterialTheme.colorScheme.error
        status.contains("Resuelta", ignoreCase = true) -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.surfaceVariant
    }
}

fun String.capitalizeWords(): String {
    return this.split(" ").joinToString(" ") { word ->
        word.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
    }
}