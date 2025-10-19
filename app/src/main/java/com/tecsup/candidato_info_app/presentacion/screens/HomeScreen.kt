package com.tecsup.candidato_info_app.presentacion.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.widget.Toast
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import com.tecsup.candidato_info_app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToDetail: (String) -> Unit,
    onNavigateToComparison: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // AQUI VENDRIA PONER UN LOGO

        // ESTE ES DEL TITULO
        Text(
            text = "Portal Ciudadano Electoral",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Información transparente sobre candidatos y autoridades",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        // LA BARRA de busqueda
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar Candidato") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    //  Luego navegará a la vista de búsqueda
                    Toast.makeText(context, "Abrir búsqueda avanzada", Toast.LENGTH_SHORT).show()
                }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // sección de funciones destacadas
        Text(
            text = "Funciones destacadas",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Tarjetas con funciones
        FeatureCard(
            icon = Icons.Default.Person,
            title = "Comparar Candidatos",
            description = "Compara perfiles y propuestas lado a lado"
        ) {
            onNavigateToComparison()
        }

        FeatureCard(
            icon = Icons.Default.Info,
            title = "Noticias",
            description = "Entérate de las últimas novedades políticas"
        ) {
            Toast.makeText(context, "Ir a noticias", Toast.LENGTH_SHORT).show()
        }

        FeatureCard(
            icon = Icons.Default.Info,
            title = "Fuentes Oficiales",
            description = "Consulta información verificada del JNE y ONPE"
        ) {
            Toast.makeText(context, "Ir a fuentes oficiales", Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun FeatureCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F4F6))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(36.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray,
                    lineHeight = 16.sp
                )
            }
        }
    }
}
