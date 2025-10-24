package com.tecsup.candidato_info_app.presentacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.tecsup.candidato_info_app.data.model.Candidato
import com.tecsup.candidato_info_app.presentacion.viewmodel.ComparisonViewModel
import com.tecsup.candidato_info_app.ui.theme.*
import com.tecsup.candidato_info_app.presentacion.components.ComparisonCandidateCard

@Composable
fun ComparisonScreen(
    navController: NavHostController,
    viewModel: ComparisonViewModel = viewModel()
) {
    var selectedTab by remember { mutableStateOf(0) }
    val candidate1 by viewModel.selectedCandidato1.collectAsState()
    val candidate2 by viewModel.selectedCandidato2.collectAsState()
    val candidatos by viewModel.candidatos.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
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
                    "COMPARAR CANDIDATOS",
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
                text = "SELECCIONA CANDIDATOS PARA COMPARAR:",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
                color = Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Selector candidato 1
            CandidateSelectorCard(
                label = "CANDIDATO 1",
                selectedCandidate = candidate1?.nombre ?: "Selecciona un candidato",
                candidatos = candidatos,
                onCandidateSelected = { viewModel.selectCandidato1(it) }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Selector candidato 2
            CandidateSelectorCard(
                label = "CANDIDATO 2",
                selectedCandidate = candidate2?.nombre ?: "Selecciona un candidato",
                candidatos = candidatos,
                onCandidateSelected = { viewModel.selectCandidato2(it) }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 🔹 Mostrar comparación si ambos están seleccionados
            if (candidate1 != null && candidate2 != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.Top
                ) {

                ComparisonCandidateCard(
                        name = candidate1!!.nombre,
                        party = candidate1!!.partido,
                        position = candidate1!!.cargo,
                        location = "${candidate1!!.ciudad}, ${candidate1!!.region}",
                        imageUrl = candidate1!!.fotoUrl,
                        modifier = Modifier.weight(1f)
                    )

                    ComparisonCandidateCard(
                        name = candidate2!!.nombre,
                        party = candidate2!!.partido,
                        position = candidate2!!.cargo,
                        location = "${candidate2!!.ciudad}, ${candidate2!!.region}",
                        imageUrl = candidate2!!.fotoUrl,
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Tabs
                TabRow(
                    selectedTabIndex = selectedTab,
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = BackgroundLight,
                    contentColor = PrimaryBlue,
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            Modifier
                                .tabIndicatorOffset(tabPositions[selectedTab])
                                .height(0.dp), // ocultamos el subrayado
                            color = Color.Transparent
                        )
                    }
                ) {
                    val tabs = listOf("Proyectos", "Denuncias", "Resumen")

                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = {
                                Text(
                                    text = title,
                                    color = if (selectedTab == index) White else PrimaryBlue,
                                    fontWeight = FontWeight.Medium
                                )
                            },
                            modifier = Modifier
                                .padding(vertical = 6.dp, horizontal = 8.dp)
                                .height(32.dp)
                                .background(
                                    color = if (selectedTab == index) PrimaryBlue else White,
                                    shape = RoundedCornerShape(50)
                                )
                        )
                    }
                }


                Spacer(modifier = Modifier.height(16.dp))

                when (selectedTab) {
                    0 -> ComparisonProjectsTab(candidate1!!, candidate2!!)
                    1 -> ComparisonDenunciasTab(candidate1!!, candidate2!!)
                    2 -> ComparisonResumenTab(candidate1!!, candidate2!!)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

// 🔽 Candidate selector card
@Composable
fun CandidateSelectorCard(
    label: String,
    selectedCandidate: String,
    candidatos: List<Candidato>,
    onCandidateSelected: (Candidato) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = MediumGray,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box {
                OutlinedButton(
                    onClick = { expanded = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = selectedCandidate,
                        style = MaterialTheme.typography.bodySmall,
                        color = Black
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    candidatos.forEach { candidato ->
                        DropdownMenuItem(
                            text = { Text(candidato.nombre) },
                            onClick = {
                                onCandidateSelected(candidato)
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
    }
}

// 🔹 Card auxiliar para info de pestañas
@Composable
fun ComparisonInfoCard(title: String, content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = title, fontWeight = FontWeight.Bold, color = Black, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            content()
        }
    }
}

// 🔹 Pestaña de proyectos
@Composable
fun ComparisonProjectsTab(candidate1: Candidato, candidate2: Candidato) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // Text(text = candidate1.nombre, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
            if (candidate1.proyectos.isNotEmpty()) {
                candidate1.proyectos.forEach {
                    ComparisonInfoCard(title = it.nombre) {
                        Text(it.descripcion, style = MaterialTheme.typography.bodySmall, color = MediumGray)
                    }
                }
            } else {
                Text("No tiene proyectos registrados.", style = MaterialTheme.typography.bodySmall, color = MediumGray)
            }
        }
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // Text(text = candidate2.nombre, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
            if (candidate2.proyectos.isNotEmpty()) {
                candidate2.proyectos.forEach {
                    ComparisonInfoCard(title = it.nombre) {
                        Text(it.descripcion, style = MaterialTheme.typography.bodySmall, color = MediumGray)
                    }
                }
            } else {
                Text("No tiene proyectos registrados.", style = MaterialTheme.typography.bodySmall, color = MediumGray)
            }
        }
    }
}

// 🔹 Pestaña de denuncias
val SuccessGreen = Color(0xFF10B981)
val ErrorRed = Color(0xFFEF4444)
val WarningOrange = Color(0xFFF59E0B)

fun estadoColor(estado: String): Color {
    return when (estado.lowercase()) {
        "resuelto", "cerrado", "finalizado" -> SuccessGreen
        "pendiente", "en proceso" -> WarningOrange
        "rechazado", "cancelado" -> ErrorRed
        else -> MediumGray
    }
}

@Composable
fun ComparisonDenunciasTab(candidate1: Candidato, candidate2: Candidato) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // Nombre del candidato eliminado
            if (candidate1.denuncias.isNotEmpty()) {
                candidate1.denuncias.forEach {
                    ComparisonInfoCard(title = it.titulo) {
                        Text(it.descripcion, style = MaterialTheme.typography.bodySmall, color = MediumGray)
                        Spacer(modifier = Modifier.height(4.dp))
                        Surface(
                            color = estadoColor(it.estado),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.padding(top = 4.dp)
                        ) {
                            Text(
                                text = "Estado: ${it.estado}",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            } else {
                Text("No tiene denuncias registradas.", style = MaterialTheme.typography.bodySmall, color = MediumGray)
            }
        }
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // Nombre del candidato eliminado
            if (candidate2.denuncias.isNotEmpty()) {
                candidate2.denuncias.forEach {
                    ComparisonInfoCard(title = it.titulo) {
                        Text(it.descripcion, style = MaterialTheme.typography.bodySmall, color = MediumGray)
                        Spacer(modifier = Modifier.height(4.dp))
                        Surface(
                            color = estadoColor(it.estado),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.padding(top = 4.dp)
                        ) {
                            Text(
                                text = "Estado: ${it.estado}",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                }
            } else {
                Text("No tiene denuncias registradas.", style = MaterialTheme.typography.bodySmall, color = MediumGray)
            }
        }
    }
}

// 🔹 Pestaña de resumen mejorada
@Composable
fun ComparisonResumenTab(candidate1: Candidato, candidate2: Candidato) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Resumen candidato 1
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                StatItem(label = "Investigaciones", value = if (candidate1.tieneInvestigaciones) "Sí" else "No")
                StatItem(label = "Denuncias", value = if (candidate1.tieneDenuncias) "Sí" else "No")
                StatItem(label = "Proyectos", value = candidate1.proyectos.size.toString())
                StatItem(label = "Denuncias", value = candidate1.denuncias.size.toString())
            }

            // Resumen candidato 2
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                StatItem(label = "Investigaciones", value = if (candidate2.tieneInvestigaciones) "Sí" else "No")
                StatItem(label = "Denuncias", value = if (candidate2.tieneDenuncias) "Sí" else "No")
                StatItem(label = "Proyectos", value = candidate2.proyectos.size.toString())
                StatItem(label = "Denuncias", value = candidate2.denuncias.size.toString())
            }
        }
    }
}

// 🔹 Item estadístico más visual
@Composable
fun StatItem(label: String, value: String) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = if (value == "Sí" || value.toIntOrNull() ?: 0 > 0) PrimaryBlue.copy(alpha = 0.1f) else LightGray,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = label, style = MaterialTheme.typography.bodyMedium, color = MediumGray)
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = if (value == "Sí" || value.toIntOrNull() ?: 0 > 0) PrimaryBlue else MediumGray
            )
        }
    }
}
