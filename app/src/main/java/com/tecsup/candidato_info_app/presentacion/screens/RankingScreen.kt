package com.tecsup.candidato_info_app.presentacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.tecsup.candidato_info_app.data.model.Candidato
import com.tecsup.candidato_info_app.presentacion.viewmodel.RankingViewModel
import com.tecsup.candidato_info_app.ui.theme.PrimaryBlue

@Composable
fun RankingScreen(
    navController: NavHostController,
    viewModel: RankingViewModel = viewModel()
) {
    val cargos = viewModel.cargos.collectAsState()
    val selectedCargo = viewModel.selectedCargo.collectAsState()
    val ranking = viewModel.ranking.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
                    "RANKING",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Cargo Selector
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                "Selecciona un cargo:",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            OutlinedButton(
                onClick = { /* Show dropdown */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                border = ButtonDefaults.outlinedButtonBorder
            ) {
                Text(selectedCargo.value, color = Color.Black)
            }
        }

        // Ranking List
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            itemsIndexed(ranking.value) { index, (candidato, votos) ->
                RankingItemCard(
                    position = index + 1,
                    candidato = candidato,
                    votos = votos
                )
            }
        }
    }
}

@Composable
fun RankingItemCard(
    position: Int,
    candidato: Candidato,
    votos: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Position Badge
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(PrimaryBlue, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "$position°",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Candidate Info
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    candidato.nombre,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    candidato.cargo,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            // Votes
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    votos.toString(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryBlue
                )
                Text(
                    "votos",
                    fontSize = 10.sp,
                    color = Color.Gray
                )
            }
        }
    }
}
