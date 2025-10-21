package com.tecsup.candidato_info_app.presentacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.tecsup.candidato_info_app.navigation.AppScreen
import com.tecsup.candidato_info_app.presentacion.viewmodel.SearchViewModel
import com.tecsup.candidato_info_app.ui.theme.*

@Composable
fun CandidateSearchScreen(
    navController: NavHostController,
    viewModel: SearchViewModel = viewModel()
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedCargo by viewModel.selectedCargo.collectAsState()
    val selectedPartido by viewModel.selectedPartido.collectAsState()
    val selectedRegion by viewModel.selectedRegion.collectAsState()

    val cargos by viewModel.cargos.collectAsState()
    val partidos by viewModel.partidos.collectAsState()
    val regiones by viewModel.regiones.collectAsState()

    val candidatos by viewModel.candidatos.collectAsState()

    val displayCargo = if (selectedCargo.isEmpty()) "Todos los cargos" else selectedCargo
    val displayPartido = if (selectedPartido.isEmpty()) "Todos los partidos" else selectedPartido
    val displayRegion = if (selectedRegion.isEmpty()) "Todas las regiones" else selectedRegion

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
                .padding(16.dp)
        ) {
            // Search Bar
            TextField(
                value = searchQuery,
                onValueChange = { viewModel.updateSearchQuery(it) },
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

            // Filters
            Text(
                text = "Filtros",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            // <CHANGE> Conectar filtros con ViewModel
            FilterDropdown(
                label = "Cargo",
                selectedValue = displayCargo,
                options = listOf("Todos los cargos") + cargos,
                onSelectionChange = { viewModel.updateCargo(if (it == "Todos los cargos") "" else it) }
            )


            Spacer(modifier = Modifier.height(12.dp))

            FilterDropdown(
                label = "Partido",
                selectedValue = displayPartido,
                options = listOf("Todos los partidos") + partidos,
                onSelectionChange = { viewModel.updatePartido(if (it == "Todos los partidos") "" else it) }
            )


            Spacer(modifier = Modifier.height(12.dp))

            FilterDropdown(
                label = "Región",
                selectedValue = displayRegion,
                options = listOf("Todas las regiones") + regiones,
                onSelectionChange = { viewModel.updateRegion(if (it == "Todas las regiones") "" else it) }
            )


            Spacer(modifier = Modifier.height(24.dp))

            // Results
            Text(
                text = "${candidatos.size} candidatos encontrados",
                style = MaterialTheme.typography.bodyMedium,
                color = MediumGray
            )


            Spacer(modifier = Modifier.height(12.dp))

            // <CHANGE> Usar LazyColumn con datos del ViewModel
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(candidatos) { candidate ->
                    CandidateListItem(
                        name = candidate.nombre,
                        party = candidate.partido,
                        position = candidate.cargo,
                        location = "${candidate.ciudad}, ${candidate.region}",
                        onClick = { navController.navigate(AppScreen.CandidateDetail.createRoute(candidate.id)) }
                    )
                }
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
