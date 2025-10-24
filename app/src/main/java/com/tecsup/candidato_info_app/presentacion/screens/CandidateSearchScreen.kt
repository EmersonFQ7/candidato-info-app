package com.tecsup.candidato_info_app.presentacion.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.tecsup.candidato_info_app.R
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

    val displayCargo = if (selectedCargo.isEmpty()) "Cargo" else selectedCargo
    val displayPartido = if (selectedPartido.isEmpty()) "Partido Político" else selectedPartido
    val displayRegion = if (selectedRegion.isEmpty()) "Región" else selectedRegion

    // <CHANGE> Determinar si hay filtros activos
    val hasActiveFilters = selectedCargo.isNotEmpty() || selectedPartido.isNotEmpty() || selectedRegion.isNotEmpty() || searchQuery.isNotEmpty()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
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
                    "BÚSQUEDA DE CANDIDATOS",
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
                    unfocusedContainerColor = (Color(0xFFF5F5F5)),
                    focusedContainerColor = White,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Filters Label
            Text(
                text = "FILTROS:",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            // <CHANGE> Filtros con diseño mejorado según Figma
            FilterDropdown(
                label = displayCargo,
                options = listOf("Cargo") + cargos,
                onSelectionChange = {
                    viewModel.updateCargo(if (it == "Cargo") "" else it)
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            FilterDropdown(
                label = displayPartido,
                options = listOf("Partido Político") + partidos,
                onSelectionChange = {
                    viewModel.updatePartido(if (it == "Partido Político") "" else it)
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            FilterDropdown(
                label = displayRegion,
                options = listOf("Región") + regiones,
                onSelectionChange = {
                    viewModel.updateRegion(if (it == "Región") "" else it)
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Results Label
            Text(
                text = "RESULTADOS ENCONTRADOS:",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                color = Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            // <CHANGE> Mostrar imagen de placeholder si no hay filtros activos
            if (!hasActiveFilters) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFFFFFFF)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.noencontrado),
                            contentDescription = "No encontrado",
                            modifier = Modifier.size(200.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            } else {
                // <CHANGE> Mostrar resultados cuando hay filtros activos
                Text(
                    text = "${candidatos.size} candidatos encontrados",
                    style = MaterialTheme.typography.bodySmall,
                    color = MediumGray
                )

                Spacer(modifier = Modifier.height(12.dp))

                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(candidatos) { candidate ->
                        CandidateSearchCard(
                            name = candidate.nombre,
                            party = candidate.partido,
                            position = candidate.cargo,
                            location = "${candidate.ciudad}, ${candidate.region}",
                            imageUrl = candidate.fotoUrl,
                            onClick = { navController.navigate(AppScreen.CandidateDetail.createRoute(candidate.id)) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FilterDropdown(
    label: String,
    options: List<String>,
    onSelectionChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = White,
                contentColor = Black
            ),
            border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
            contentPadding = PaddingValues(0.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color(0xFF666666),
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp)
                )

                Text(
                    text = label,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF666666),
                    fontWeight = FontWeight.Medium
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
fun CandidateSearchCard(
    name: String,
    party: String,
    position: String,
    location: String,
    imageUrl: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar
            AsyncImage(
                model = imageUrl,
                contentDescription = name,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

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
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
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
                            color = White,
                            fontSize = androidx.compose.ui.unit.TextUnit(10f, androidx.compose.ui.unit.TextUnitType.Sp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("📍", fontSize = androidx.compose.ui.unit.TextUnit(12f, androidx.compose.ui.unit.TextUnitType.Sp))
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

