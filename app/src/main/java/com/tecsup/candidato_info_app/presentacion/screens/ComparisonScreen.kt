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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.tecsup.candidato_info_app.data.model.Candidato
import com.tecsup.candidato_info_app.data.model.Denuncia
import com.tecsup.candidato_info_app.data.model.Proyecto
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
                text = "Selecciona candidatos para comparar",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Selector 1
            CandidateSelectorCard(
                label = "Candidato 1",
                selectedCandidate = candidate1?.nombre ?: "Selecciona un candidato",
                candidatos = candidatos,
                onCandidateSelected = { viewModel.selectCandidato1(it) }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Selector 2
            CandidateSelectorCard(
                label = "Candidato 2",
                selectedCandidate = candidate2?.nombre ?: "Selecciona un candidato",
                candidatos = candidatos,
                onCandidateSelected = { viewModel.selectCandidato2(it) }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Mostrar comparación solo si hay dos candidatos seleccionados
            if (candidate1 != null && candidate2 != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
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
                        text = { Text("Denuncias") }
                    )
                    Tab(
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 },
                        text = { Text("Resumen") }
                    )
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
                color = MediumGray
            )
            Spacer(modifier = Modifier.height(8.dp))

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
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
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


// Helper card for displaying info in tabs
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

@Composable
fun ComparisonProjectsTab(candidate1: Candidato, candidate2: Candidato) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = candidate1.nombre, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
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
            Text(text = candidate2.nombre, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
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

@Composable
fun ComparisonDenunciasTab(candidate1: Candidato, candidate2: Candidato) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = candidate1.nombre, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
            if (candidate1.denuncias.isNotEmpty()) {
                candidate1.denuncias.forEach {
                    ComparisonInfoCard(title = it.titulo) {
                        Text(it.descripcion, style = MaterialTheme.typography.bodySmall, color = MediumGray)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("Estado: ${it.estado}", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold)
                    }
                }
            } else {
                Text("No tiene denuncias registradas.", style = MaterialTheme.typography.bodySmall, color = MediumGray)
            }
        }
        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = candidate2.nombre, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
            if (candidate2.denuncias.isNotEmpty()) {
                candidate2.denuncias.forEach {
                    ComparisonInfoCard(title = it.titulo) {
                        Text(it.descripcion, style = MaterialTheme.typography.bodySmall, color = MediumGray)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("Estado: ${it.estado}", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold)
                    }
                }
            } else {
                Text("No tiene denuncias registradas.", style = MaterialTheme.typography.bodySmall, color = MediumGray)
            }
        }
    }
}

@Composable
fun ComparisonResumenTab(candidate1: Candidato, candidate2: Candidato) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Candidate 1 Summary
            Column(modifier = Modifier.weight(1f)) {
                Text(text = candidate1.nombre, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Spacer(modifier = Modifier.height(8.dp))
                SummaryItem(label = "Investigaciones", value = if (candidate1.tieneInvestigaciones) "Sí" else "No")
                SummaryItem(label = "Denuncias", value = if (candidate1.tieneDenuncias) "Sí" else "No")
                SummaryItem(label = "N° Proyectos", value = candidate1.proyectos.size.toString())
                SummaryItem(label = "N° Denuncias", value = candidate1.denuncias.size.toString())
            }
            // Candidate 2 Summary
            Column(modifier = Modifier.weight(1f)) {
                Text(text = candidate2.nombre, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Spacer(modifier = Modifier.height(8.dp))
                SummaryItem(label = "Investigaciones", value = if (candidate2.tieneInvestigaciones) "Sí" else "No")
                SummaryItem(label = "Denuncias", value = if (candidate2.tieneDenuncias) "Sí" else "No")
                SummaryItem(label = "N° Proyectos", value = candidate2.proyectos.size.toString())
                SummaryItem(label = "N° Denuncias", value = candidate2.denuncias.size.toString())
            }
        }
    }
}

@Composable
fun SummaryItem(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, style = MaterialTheme.typography.bodyMedium, color = MediumGray)
        Text(text = value, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold, color = Black)
    }
    Spacer(modifier = Modifier.height(4.dp))
}
