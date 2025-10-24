package com.tecsup.candidato_info_app.presentacion.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.tecsup.candidato_info_app.data.model.HistorialPolitico
import com.tecsup.candidato_info_app.data.model.Proyecto
import com.tecsup.candidato_info_app.presentacion.viewmodel.CandidateViewModel
import com.tecsup.candidato_info_app.ui.theme.*
import com.tecsup.candidato_info_app.R

@Composable
fun CandidateDetailScreen(
    navController: NavHostController,
    candidateId: String,
    viewModel: CandidateViewModel = viewModel()
) {
    var selectedTab by remember { mutableStateOf(0) }
    var showVotingModal by remember { mutableStateOf(false) }
    var votingStep by remember { mutableStateOf(0) }

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
                    "PERFIL DEL CANDIDATO",
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
            candidate?.let { cand ->

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 1.dp, vertical = 1.dp)
                            .shadow(8.dp, RoundedCornerShape(16.dp)),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                    )


                    {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            // Imagen del candidato
                            AsyncImage(
                                model = cand.fotoUrl,
                                contentDescription = "Foto de ${cand.nombre}",
                                modifier = Modifier
                                    .size(110.dp)
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

                            // Botón del partido
                            Button(
                                onClick = { },
                                modifier = Modifier.height(28.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                                shape = RoundedCornerShape(50),
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

                            Spacer(modifier = Modifier.height(4.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center // opcional, centra todo horizontalmente
                            ) {
                                Text(
                                    text = "📍",
                                    fontSize = 14.sp,
                                    color = MediumGray
                                )
                                Spacer(modifier = Modifier.width(4.dp)) // pequeño espacio entre el ícono y el texto
                                Text(
                                    text = "${cand.ciudad}, ${cand.region}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MediumGray
                                )
                            }

                        }
                    }


                    IconButton(
                        onClick = { showVotingModal = true },
                        modifier = Modifier
                            .padding(12.dp)
                            .size(48.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.votoboton),
                            contentDescription = "Votar por candidato",
                            modifier = Modifier.size(48.dp)
                        )
                    }

                }

                Spacer(modifier = Modifier.height(16.dp))

                // Alerta de denuncias
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
                            fontSize = 20.sp,
                            color = if (hasDenuncias) ErrorRed else SuccessGreen
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (hasDenuncias)
                                "Tiene ${cand.denuncias.size} denuncia(s) registrada(s)"
                            else
                                "No se registran denuncias o investigaciones activas",
                            style = MaterialTheme.typography.bodySmall,
                            color = if (hasDenuncias) ErrorRed else SuccessGreen
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                TabRow(
                    selectedTabIndex = selectedTab,
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = BackgroundLight,
                    contentColor = PrimaryBlue,
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            Modifier
                                .tabIndicatorOffset(tabPositions[selectedTab])
                                .height(2.dp),
                            color = PrimaryBlue
                        )
                    }
                ) {
                    val tabs = listOf("Proyectos", "Historial", "Fuentes")

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
                                .height(32.dp) // controla altura total de la pastilla

                                .background(
                                    color = if (selectedTab == index) PrimaryBlue else White,
                                    shape = RoundedCornerShape(50)
                                )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                when (selectedTab) {
                    0 -> ProjectsTabContent(cand.proyectos)
                    1 -> HistorialTabContent(cand.historialPolitico)
                    2 -> FuentesTabContent()
                }
            }
        }
    }

    if (showVotingModal) {
        VotingModal(
            onDismiss = { showVotingModal = false },
            onConfirm = { showVotingModal = false },
            votingStep = votingStep,
            onStepChange = { votingStep = it }
        )
    }
}

// --------------------------------------------------------------------
// MODAL DE VOTACIÓN
// --------------------------------------------------------------------
@Composable
fun VotingModal(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    votingStep: Int,
    onStepChange: (Int) -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = if (votingStep == 0) "¿Votarías por este candidato?" else "Confirmación",
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Text(
                text = if (votingStep == 0)
                    "Tu voto solo será válido dentro de esta aplicación con fines informativos."
                else
                    "Tu voto ha sido registrado exitosamente."
            )
        },
        confirmButton = {
            Button(
                onClick = {
                    if (votingStep == 0) onStepChange(1) else onConfirm()
                },
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue)
            ) {
                Text(if (votingStep == 0) "Sí" else "Aceptar", color = White)
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            ) {
                Text("Cancelar", color = Black)
            }
        }
    )
}

// --------------------------------------------------------------------
// TABS
// --------------------------------------------------------------------
@Composable
fun ProjectsTabContent(proyectos: List<Proyecto>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Proyectos y Propuestas", fontWeight = FontWeight.Bold, color = Black)
        Spacer(modifier = Modifier.height(12.dp))
        proyectos.forEach { proyecto ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("✓", fontSize = 18.sp, color = SuccessGreen)
                Spacer(modifier = Modifier.width(12.dp))
                Text(proyecto.nombre, color = DarkGray)
            }
        }
    }
}

@Composable
fun HistorialTabContent(historial: List<HistorialPolitico>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Historial Político", fontWeight = FontWeight.Bold, color = Black)
        Spacer(modifier = Modifier.height(12.dp))
        historial.forEach { h ->
            Column(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                Text("${h.cargo} - ${h.institucion}", fontWeight = FontWeight.SemiBold)
                Text("${h.fechaInicio} - ${h.fechaFin ?: "Presente"}", color = MediumGray)
                Text(h.descripcion, color = DarkGray)
            }
        }
    }
}

@Composable
fun FuentesTabContent() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Fuentes Oficiales", fontWeight = FontWeight.Bold, color = Black)
        Spacer(modifier = Modifier.height(12.dp))
        val sources = listOf(
            "ONPE - Oficina Nacional de Procesos Electorales",
            "Congreso de la República - Portal del Congreso"
        )
        sources.forEach { src ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF6FF))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("📄", fontSize = 20.sp)
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(src, color = PrimaryBlue)
                }
            }
        }
    }
}

