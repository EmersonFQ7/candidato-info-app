package com.tecsup.candidato_info_app.presentacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tecsup.candidato_info_app.data.CandidateRepository
import com.tecsup.candidato_info_app.navigation.AppScreen
import com.tecsup.candidato_info_app.ui.theme.*

@Composable
fun CandidateSearchScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCargo by remember { mutableStateOf("Todos los cargos") }
    var selectedPartido by remember { mutableStateOf("Todos los partidos") }
    var selectedRegion by remember { mutableStateOf("Todas las regiones") }

    // Filtrar candidatos según búsqueda y filtros
    val filteredCandidates by remember(searchQuery, selectedCargo, selectedPartido, selectedRegion) {
        derivedStateOf {
            CandidateRepository.candidates.filter { candidate ->
                val matchesQuery = candidate.name.contains(searchQuery, ignoreCase = true) ||
                        candidate.party.contains(searchQuery, ignoreCase = true) ||
                        candidate.location.contains(searchQuery, ignoreCase = true)
                val matchesCargo = selectedCargo == "Todos los cargos" || candidate.position == selectedCargo
                val matchesPartido = selectedPartido == "Todos los partidos" || candidate.party == selectedPartido
                val matchesRegion = selectedRegion == "Todas las regiones" || candidate.location == selectedRegion

                matchesQuery && matchesCargo && matchesPartido && matchesRegion
            }
        }
    }

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
                    text = "Búsqueda de Candidatos",
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
            // Search Bar
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Buscar por nombre, partido o región...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = MediumGray
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = White,
                    focusedContainerColor = White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Filtros
            Text(
                text = "Filtros",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            FilterDropdown(
                label = "Cargo",
                selectedValue = selectedCargo,
                options = listOf("Todos los cargos", "Candidato al Congreso", "Candidato a la Presidencia", "Candidato a la Alcaldía"),
                onSelectionChange = { selectedCargo = it }
            )

            Spacer(modifier = Modifier.height(12.dp))

            FilterDropdown(
                label = "Partido",
                selectedValue = selectedPartido,
                options = listOf("Todos los partidos") + CandidateRepository.candidates.map { it.party }.distinct(),
                onSelectionChange = { selectedPartido = it }
            )

            Spacer(modifier = Modifier.height(12.dp))

            FilterDropdown(
                label = "Región",
                selectedValue = selectedRegion,
                options = listOf("Todas las regiones") + CandidateRepository.candidates.map { it.location }.distinct(),
                onSelectionChange = { selectedRegion = it }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Resultados
            Text(
                text = "${filteredCandidates.size} candidatos encontrados",
                style = MaterialTheme.typography.bodyMedium,
                color = MediumGray
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Lista de candidatos
            filteredCandidates.forEach { candidate ->
                CandidateListItem(
                    name = candidate.name,
                    party = candidate.party,
                    position = candidate.position,
                    location = candidate.location
                ) {
                    // Navegar al perfil del candidato usando su ID
                    navController.navigate(AppScreen.CandidateDetail.createRoute("2"))
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun FilterDropdown(
    label: String,
    selectedValue: String,
    options: List<String>,
    onSelectionChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = White,
                contentColor = Black
            ),
            border = ButtonDefaults.outlinedButtonBorder
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.labelSmall,
                        color = MediumGray
                    )
                    Text(
                        text = selectedValue,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Black,
                        fontWeight = FontWeight.Medium
                    )
                }
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = MediumGray,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(0.9f)
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelectionChange(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun CandidateListItem(
    name: String,
    party: String,
    position: String,
    location: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceLight),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE5A76F)),
                contentAlignment = Alignment.Center
            ) {
                Text("👤", fontSize = androidx.compose.ui.unit.TextUnit(24f, androidx.compose.ui.unit.TextUnitType.Sp))
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    color = Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .height(28.dp)
                            .wrapContentWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 0.dp)
                    ) {
                        Text(
                            text = party,
                            style = MaterialTheme.typography.labelSmall,
                            color = White
                        )
                    }
                    Text(
                        text = position,
                        style = MaterialTheme.typography.bodySmall,
                        color = MediumGray
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("📍", fontSize = androidx.compose.ui.unit.TextUnit(14f, androidx.compose.ui.unit.TextUnitType.Sp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = location,
                        style = MaterialTheme.typography.bodySmall,
                        color = MediumGray
                    )
                }
            }
        }
    }
}
