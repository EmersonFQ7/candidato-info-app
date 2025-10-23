package com.tecsup.candidato_info_app.presentacion.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tecsup.candidato_info_app.navigation.AppScreen
import com.tecsup.candidato_info_app.ui.theme.*
import com.tecsup.candidato_info_app.R
import com.tecsup.candidato_info_app.data.model.FeatureItem

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryBlue)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .align(Alignment.TopCenter),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logooficial),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = { navController.navigate(AppScreen.CandidateSearch.route) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlueDark),
                    shape = RoundedCornerShape(35.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Buscar Candidatos",
                        fontSize = 17.sp,
                        color = Color.White
                    )
                }


            }
        }

        // Zona azul con tabs y contenido
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 280.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            var selectedTab by remember { mutableStateOf(0) }

            // Tabs personalizados para que uno sea azul y otro blanco según selección
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .border(2.dp, PrimaryBlue, RoundedCornerShape(22.dp)) // borde azul
                    .clip(RoundedCornerShape(22.dp))
                    .background(Color.White) // fondo blanco del contenedor
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp), // espacio para ver el borde
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    TabButton(
                        text = "¿Qué puedo hacer?",
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        modifier = Modifier.weight(1f)
                    )
                    TabButton(
                        text = "Ranking",
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        modifier = Modifier.weight(1f)
                    )
                }
            }


            Spacer(modifier = Modifier.height(16.dp))

            when (selectedTab) {
                0 -> WhatCanIDoGrid(navController)
                1 -> RankingTab(navController)
            }
        }
    }
}

@Composable
fun TabButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (selected) PrimaryBlue else Color.White
    val textColor = if (selected) Color.White else PrimaryBlue

    Box(
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(18.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}

@Composable
fun WhatCanIDoGrid(navController: NavHostController) {
    // Usamos LazyVerticalGrid para 2 columnas
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxHeight(),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(4) { index ->
            val item = when (index) {
                0 -> FeatureItem(
                    title = "COMPARAR\nCANDIDATOS",
                    description = "Compara perfiles y propuestas lado a lado",
                    imageRes = R.drawable.compararcandidatos
                )
                1 -> FeatureItem(
                    title = "VER ÚLTIMAS\nNOTICIAS",
                    description = "Últimas noticias electorales y políticas",
                    imageRes = R.drawable.noticias
                )
                2 -> FeatureItem(
                    title = "CONOCE DATOS\nIMPORTANTES DE LAS ELECCIONES 2026",
                    description = "Leer más...",
                    imageRes = R.drawable.datoimportantes
                )
                else -> FeatureItem(
                    title = "FUENTES OFICIALES",
                    description = "Acceso directo a información de fuentes oficiales",
                    imageRes = R.drawable.fuenteoficales
                )
            }
            FeatureCardGrid(item) {

                when (index) {
                    0 -> navController.navigate(AppScreen.Comparison.route)
                    1 -> navController.navigate(AppScreen.News.route)
                    2 -> navController.navigate(AppScreen.ImportantData.route)
                    3 -> navController.navigate(AppScreen.OfficialSources.route)
                }
            }
        }
    }
}

@Composable
fun FeatureCardGrid(
    item: FeatureItem,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp) // altura fija para mantener proporción
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {

            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            )

            // Texto inferior
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = item.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = item.description,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun RankingTab(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Top 5 Candidatos",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = Black,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Mock ranking data
        val rankingCandidates = listOf(
            Triple("Rafael Lopez Aliaga", "Renovación Popular", 1),
            Triple("Rafael Lopez Aliaga", "Renovación Popular", 2),
            Triple("Rafael Lopez Aliaga", "Renovación Popular", 3),
            Triple("Rafael Lopez Aliaga", "Renovación Popular", 4),
            Triple("Rafael Lopez Aliaga", "Renovación Popular", 5)
        )

        rankingCandidates.forEach { (name, party, position) ->
            RankingCard(
                position = position,
                name = name,
                party = party,
                onClick = { navController.navigate(AppScreen.CandidateDetail.createRoute("1")) }
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun RankingCard(
    position: Int,
    name: String,
    party: String,
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
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Position Badge
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(PrimaryBlue, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = position.toString() + "°",
                    style = MaterialTheme.typography.headlineSmall,
                    color = White,
                    fontWeight = FontWeight.Bold
                )
            }

            // Candidate Info
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Black
                )
                Text(
                    text = party,
                    style = MaterialTheme.typography.bodySmall,
                    color = MediumGray
                )
            }
        }
    }
}
