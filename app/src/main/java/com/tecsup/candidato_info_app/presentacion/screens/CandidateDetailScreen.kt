package com.tecsup.candidato_info_app.presentacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.tecsup.candidato_info_app.presentacion.viewmodel.CandidateViewModel
import com.tecsup.candidato_info_app.ui.theme.*
import com.tecsup.candidato_info_app.data.model.Candidato
import com.tecsup.candidato_info_app.data.model.HistorialPolitico
import com.tecsup.candidato_info_app.data.model.Proyecto
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import com.tecsup.candidato_info_app.R


@Composable
fun CandidateDetailScreen(
    navController: NavHostController,
    candidateId: String,
    viewModel: CandidateViewModel = viewModel()
) {
    var selectedTab by remember { mutableStateOf(0) }

    // <CHANGE> Cargar candidato del ViewModel
    LaunchedEffect(candidateId) {
        viewModel.getCandidatoById(candidateId)
    }


    val candidate by viewModel.candidato.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PrimaryBlue)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = White
                    )
                }
                Text(
                    text = "Perfil del Candidato",
                    style = MaterialTheme.typography.headlineSmall,
                    color = White,
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
            candidate?.let { cand ->
                // Candidate Card
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = SurfaceLight),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Avatar
                        Image(
                            painter = painterResource(id = R.drawable.rafael_lopez),
                            contentDescription = "Foto de Rafael López Aliaga",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )


                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = cand.nombre,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = Black
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = { },
                            modifier = Modifier.height(32.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp)
                        ) {
                            Text(
                                text = cand.partido,
                                style = MaterialTheme.typography.labelSmall,
                                color = White
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = cand.cargo,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MediumGray
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text("📍", fontSize = androidx.compose.ui.unit.TextUnit(16f, androidx.compose.ui.unit.TextUnitType.Sp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "${cand.ciudad}, ${cand.region}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MediumGray
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Status Alert
                val hasDenuncias = cand.denuncias.isNotEmpty()
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (hasDenuncias) Color(0xFFFEE2E2) else Color(0xFFECFDF5)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            if (hasDenuncias) "⚠" else "✓",
                            fontSize = androidx.compose.ui.unit.TextUnit(20f, androidx.compose.ui.unit.TextUnitType.Sp),
                            color = if (hasDenuncias) ErrorRed else SuccessGreen
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (hasDenuncias) "Tiene ${cand.denuncias.size} denuncia(s) registrada(s)" else "No se registran denuncias o investigaciones activas",
                            style = MaterialTheme.typography.bodySmall,
                            color = if (hasDenuncias) ErrorRed else SuccessGreen
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Tabs
                TabRow(
                    selectedTabIndex = selectedTab,
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = BackgroundLight,
                    contentColor = PrimaryBlue
                ) {
                    Tab(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        text = { Text("Proyectos") }
                    )
                    Tab(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        text = { Text("Historial") }
                    )
                    Tab(
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 },
                        text = { Text("Fuentes") }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Tab Content
                when (selectedTab) {
                    0 -> ProjectsTabContent(cand.proyectos)
                    1 -> HistorialTabContent(cand.historialPolitico)
                    2 -> FuentesTabContent()
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Compare Button
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "Comparar con otros candidatos",
                        style = MaterialTheme.typography.labelLarge,
                        color = White
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ProjectsTabContent(proyectos: List<Proyecto>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Proyectos y Propuestas",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        proyectos.forEach { proyecto ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("✓", fontSize = 18.sp, color = SuccessGreen)
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = proyecto.nombre, // Usa el nombre del proyecto
                    style = MaterialTheme.typography.bodySmall,
                    color = DarkGray,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun HistorialTabContent(historial: List<HistorialPolitico>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Historial Político",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        historial.forEach { position ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = "${position.cargo} - ${position.institucion}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = DarkGray
                )
                Text(
                    text = "${position.fechaInicio} - ${position.fechaFin ?: "Presente"}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MediumGray
                )
                Text(
                    text = position.descripcion,
                    style = MaterialTheme.typography.bodySmall,
                    color = DarkGray
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun FuentesTabContent() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Fuentes Oficiales",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Verifica la información en las siguientes fuentes oficiales:",
            style = MaterialTheme.typography.bodySmall,
            color = MediumGray
        )

        Spacer(modifier = Modifier.height(12.dp))

        val sources = listOf(
            "ONPE - Oficina Nacional de Procesos Electorales",
            "Congreso de la República - Portal del Congreso"
        )

        sources.forEach { source ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF6FF)),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("📄", fontSize = androidx.compose.ui.unit.TextUnit(20f, androidx.compose.ui.unit.TextUnitType.Sp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = source,
                        style = MaterialTheme.typography.bodySmall,
                        color = PrimaryBlue,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}
