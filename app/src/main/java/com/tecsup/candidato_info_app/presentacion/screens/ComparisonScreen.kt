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
import androidx.navigation.NavHostController
import com.tecsup.candidato_info_app.ui.theme.*

@Composable
fun ComparisonScreen(navController: NavHostController) {
    var selectedTab by remember { mutableStateOf(0) }

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

            // Candidate 1 Selector
            CandidateSelectorCard(
                label = "Candidato 1",
                selectedCandidate = "Carlos Alberto Mendoza Silva"
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Candidate 2 Selector
            CandidateSelectorCard(
                label = "Candidato 2",
                selectedCandidate = "Jorge Luis Sánchez Prado"
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Comparison Cards
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ComparisonCandidateCard(
                    name = "Carlos Alberto\nMendoza Silva",
                    party = "Fuerza Popular",
                    position = "Alcalde Provincial",
                    location = "Arequipa",
                    modifier = Modifier.weight(1f)
                )

                ComparisonCandidateCard(
                    name = "Jorge Luis\nSánchez Prado",
                    party = "Acción Popular",
                    position = "Gobernador Regional",
                    location = "La Libertad",
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

            // Tab Content
            when (selectedTab) {
                0 -> ComparisonProjectsTab()
                1 -> ComparisonDenunciasTab()
                2 -> ComparisonResumenTab()
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun CandidateSelectorCard(
    label: String,
    selectedCandidate: String
) {
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
                onClick = { },
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
                .padding(12.dp),
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

            Text(
                text = name,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = Black,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .height(24.dp)
                    .wrapContentWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp)
            ) {
                Text(
                    text = party,
                    style = MaterialTheme.typography.labelSmall,
                    color = White,
                    fontSize = androidx.compose.ui.unit.TextUnit(10f, androidx.compose.ui.unit.TextUnitType.Sp)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = position,
                style = MaterialTheme.typography.labelSmall,
                color = MediumGray,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = location,
                style = MaterialTheme.typography.labelSmall,
                color = MediumGray,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

@Composable
fun ComparisonProjectsTab() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ComparisonColumn(
                title = "Proyectos",
                items = listOf(
                    "Plan Maestro de Desarrollo Urbano" to true,
                    "Carretera Interoceanica Regional" to true,
                    "Sistema de Agua Potable Rural" to true,
                    "Red de Parques Metropolitanos" to true,
                    "Hospitales Modulares en Zonas Alejadas" to true
                ),
                total = "Total: 3 proyectos",
                modifier = Modifier.weight(1f)
            )

            ComparisonColumn(
                title = "Proyectos",
                items = listOf(
                    "Plan Maestro de Desarrollo Urbano" to true,
                    "Carretera Interoceanica Regional" to true,
                    "Sistema de Agua Potable Rural" to true,
                    "Red de Parques Metropolitanos" to true,
                    "Hospitales Modulares en Zonas Alejadas" to true
                ),
                total = "Total: 3 proyectos",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComparisonColumn(
    title: String,
    items: List<Pair<String, Boolean>>,
    total: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9FAFB)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold,
                color = Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            items.forEach { (item, hasItem) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (hasItem) "✓" else "✗",
                        fontSize = androidx.compose.ui.unit.TextUnit(14f, androidx.compose.ui.unit.TextUnitType.Sp),
                        color = if (hasItem) SuccessGreen else ErrorRed
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = item,
                        style = MaterialTheme.typography.labelSmall,
                        color = DarkGray,
                        fontSize = androidx.compose.ui.unit.TextUnit(11f, androidx.compose.ui.unit.TextUnitType.Sp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = total,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = Black
            )
        }
    }
}

@Composable
fun ComparisonDenunciasTab() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            DenunciasColumn(
                items = listOf(
                    "Investigación por presunto conflicto de intereses (2019) - En proceso" to true,
                    "Denuncia por nepotismo (2017) - Archivada por falta de pruebas" to false,
                    "Investigación administrativa (2018) - Sobreseída" to false
                ),
                modifier = Modifier.weight(1f)
            )

            DenunciasColumn(
                items = listOf(
                    "Investigación por presunto conflicto de intereses (2019) - En proceso" to true,
                    "Denuncia por nepotismo (2017) - Archivada por falta de pruebas" to false,
                    "Investigación administrativa (2018) - Sobreseída" to false
                ),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun DenunciasColumn(
    items: List<Pair<String, Boolean>>,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFAF5F5)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            items.forEach { (item, isActive) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "✗",
                        fontSize = androidx.compose.ui.unit.TextUnit(14f, androidx.compose.ui.unit.TextUnitType.Sp),
                        color = if (isActive) ErrorRed else MediumGray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = item,
                        style = MaterialTheme.typography.labelSmall,
                        color = DarkGray,
                        fontSize = androidx.compose.ui.unit.TextUnit(11f, androidx.compose.ui.unit.TextUnitType.Sp)
                    )
                }
            }
        }
    }
}

@Composable
fun ComparisonResumenTab() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Resumen Comparativo",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF9FAFB)),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Proyectos Presentados",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = Black
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "3",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlue
                        )
                        Text(
                            text = "Carlos",
                            style = MaterialTheme.typography.bodySmall,
                            color = MediumGray
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "3",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = PrimaryBlue
                        )
                        Text(
                            text = "Jorge",
                            style = MaterialTheme.typography.bodySmall,
                            color = MediumGray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Denuncias",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = Black
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = ErrorRed
                        )
                        Text(
                            text = "Carlos",
                            style = MaterialTheme.typography.bodySmall,
                            color = MediumGray
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "1",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = ErrorRed
                        )
                        Text(
                            text = "Jorge",
                            style = MaterialTheme.typography.bodySmall,
                            color = MediumGray
                        )
                    }
                }
            }
        }
    }
}