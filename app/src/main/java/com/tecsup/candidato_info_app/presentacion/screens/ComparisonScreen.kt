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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.tecsup.candidato_info_app.data.model.Candidato
import com.tecsup.candidato_info_app.data.model.Proyecto
import com.tecsup.candidato_info_app.presentacion.viewmodel.ComparisonViewModel
import com.tecsup.candidato_info_app.ui.theme.*

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
                    text = "Comparar Candidatos",
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
                        modifier = Modifier.weight(1f)
                    )

                    ComparisonCandidateCard(
                        name = candidate2!!.nombre,
                        party = candidate2!!.partido,
                        position = candidate2!!.cargo,
                        location = "${candidate2!!.ciudad}, ${candidate2!!.region}",
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

@Composable
fun ComparisonCandidateCard(
    name: String,
    party: String,
    position: String,
    location: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE5A76F)),
                contentAlignment = Alignment.Center
            ) {
                Text("👤", fontSize = androidx.compose.ui.unit.TextUnit(28f, androidx.compose.ui.unit.TextUnitType.Sp))
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(name, fontWeight = FontWeight.Bold, color = Black)
            Text(party, color = PrimaryBlue)
            Text(position, color = MediumGray)
            Text(location, color = MediumGray)
        }
    }
}

// Tabs reutilizados (no cambiaron)
@Composable fun ComparisonProjectsTab(candidate1: Candidato, candidate2: Candidato) { /* igual que antes */ }
@Composable fun ComparisonDenunciasTab(candidate1: Candidato, candidate2: Candidato) { /* igual que antes */ }
@Composable fun ComparisonResumenTab(candidate1: Candidato, candidate2: Candidato) { /* igual que antes */ }
