package com.tecsup.candidato_info_app.presentacion.screens

import android.content.Intent // Para abrir una URL externa
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tecsup.candidato_info_app.ui.theme.*

@Composable
fun OfficialSourcesScreen(navController: NavHostController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
         Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                .background(PrimaryBlue)
                .padding(top = 40.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                Text(
                    text = "FUENTES OFICIALES",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        //  en 2 columnas
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                OfficialSourceCard(
                    title = "ONPE",
                    description = "Información oficial sobre procesos electorales, candidatos registrados y resultados electorales.",
                    icon = "🏛️",
                    url = "https://www.onpe.gob.pe/"
                )
            }

            item {
                OfficialSourceCard(
                    title = "Congreso de la República",
                    description = "Información sobre congresistas, proyectos de ley, votaciones y actividades legislativas.",
                    icon = "📋",
                    url = "https://www.congreso.gob.pe/"
                )
            }

            item {
                OfficialSourceCard(
                    title = "Poder Judicial",
                    description = "Información sobre procesos judiciales, sentencias y antecedentes penales.",
                    icon = "⚖️",
                    url = "https://www.pj.gob.pe/"
                )
            }

            item {
                OfficialSourceCard(
                    title = "RENIEC",
                    description = "Información sobre identidad y estado civil de personas naturales.",
                    icon = "🆔",
                    url = "https://www.reniec.gob.pe/"
                )
            }

            item {
                OfficialSourceCard(
                    title = "SUNAT",
                    description = "Información sobre contribuyentes y declaraciones de impuestos.",
                    icon = "💼",
                    url = "https://www.sunat.gob.pe/"
                )
            }
        }
    }
}

@Composable
fun OfficialSourceCard(
    title: String,
    description: String,
    icon: String,
    url: String
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp), // tamaño fijo igual para todos
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            // === Parte superior: icono ===
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(Color(0xFFE0E7FF), shape = RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = icon, fontSize = 26.sp)
            }

            // === Texto: título y descripción ===
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = Black,
                    textAlign = TextAlign.Center,
                    maxLines = 2, // permite hasta 2 líneas
                    lineHeight = 18.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = DarkGray,
                    textAlign = TextAlign.Center,
                    maxLines = 4, // un poco más de espacio para textos largos
                    lineHeight = 16.sp
                )
            }

            // Boton Visitar aqui ya se esta usando Intent el abrir una URL externa
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .height(32.dp)
                    .width(90.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                contentPadding = PaddingValues(horizontal = 0.dp)
            ) {
                Text(
                    text = "Visitar",
                    style = MaterialTheme.typography.labelSmall,
                    color = White
                )
            }
        }
    }
}

