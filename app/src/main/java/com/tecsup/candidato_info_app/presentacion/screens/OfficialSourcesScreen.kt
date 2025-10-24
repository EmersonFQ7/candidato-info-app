package com.tecsup.candidato_info_app.presentacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tecsup.candidato_info_app.ui.theme.*

@Composable
fun OfficialSourcesScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                .background(PrimaryBlue)
                .padding(top = 32.dp, bottom = 5.dp, start = 16.dp, end = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Text(
                    "FUENTES OFICIALES",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Verifica la información en las siguientes fuentes oficiales:",
                style = MaterialTheme.typography.bodyMedium,
                color = DarkGray
            )

            Spacer(modifier = Modifier.height(20.dp))

            // ONPE
            OfficialSourceCard(
                title = "ONPE",
                subtitle = "Oficina Nacional de Procesos Electorales",
                description = "Información oficial sobre procesos electorales, candidatos registrados y resultados electorales.",
                icon = "🏛️"
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Congreso
            OfficialSourceCard(
                title = "Congreso de la República",
                subtitle = "Portal del Congreso",
                description = "Información sobre congresistas, proyectos de ley, votaciones y actividades legislativas.",
                icon = "📋"
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Poder Judicial
            OfficialSourceCard(
                title = "Poder Judicial",
                subtitle = "Sistema de Justicia",
                description = "Información sobre procesos judicales, sentencias y antecedentes penales.",
                icon = "⚖️"
            )

            Spacer(modifier = Modifier.height(12.dp))

            // RENIEC
            OfficialSourceCard(
                title = "RENIEC",
                subtitle = "Registro Nacional de Identificación y Estado Civil",
                description = "Información sobre identidad y estado civil de personas naturales.",
                icon = "🆔"
            )

            Spacer(modifier = Modifier.height(12.dp))

            // SUNAT
            OfficialSourceCard(
                title = "SUNAT",
                subtitle = "Superintendencia Nacional de Aduanas y de Administración Tributaria",
                description = "Información sobre contribuyentes y declaraciones de impuestos.",
                icon = "💼"
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Transparencia Electoral",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Estas fuentes oficiales garantizan la transparencia y confiabilidad de la información sobre candidatos y autoridades. Consulta directamente en los portales oficiales para obtener datos actualizados y verificados.",
                style = MaterialTheme.typography.bodySmall,
                color = MediumGray
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun OfficialSourceCard(
    title: String,
    subtitle: String,
    description: String,
    icon: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            color = Color(0xFFE0E7FF),
                            shape = RoundedCornerShape(12.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(icon, fontSize = androidx.compose.ui.unit.TextUnit(24f, androidx.compose.ui.unit.TextUnitType.Sp))
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold,
                        color = Black
                    )
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = MediumGray
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = DarkGray
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .align(Alignment.End)
                    .height(32.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp)
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
