package com.tecsup.candidato_info_app.presentacion.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import coil.compose.AsyncImage // Usamos la librería Coil
import com.tecsup.candidato_info_app.ui.theme.Black
import com.tecsup.candidato_info_app.ui.theme.MediumGray
import com.tecsup.candidato_info_app.ui.theme.LightGray
import com.tecsup.candidato_info_app.ui.theme.PrimaryBlue
import com.tecsup.candidato_info_app.ui.theme.SurfaceLight

@Composable
fun ComparisonCandidateCard(
    name: String,
    party: String,
    position: String,
    location: String,
    imageUrl: String, // <-- ¡NUEVO PARÁMETRO DE IMAGEN!
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
            // REEMPLAZO DEL AVATAR ESTÁTICO POR ASYNCIMAGE DE COIL
            AsyncImage(
                model = imageUrl, // La URL única de la foto del Candidato
                contentDescription = "Foto del Candidato para Comparación: $name",
                contentScale = ContentScale.Crop, // Escala para llenar el círculo
                modifier = Modifier
                    .size(60.dp) // Tamaño similar al anterior (60.dp)
                    .clip(CircleShape)
                    .background(LightGray), // Placeholder si la carga falla
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(name, fontWeight = FontWeight.Bold, color = Black)
            Text(party, color = PrimaryBlue)
            Text(position, color = MediumGray)
            Text(location, color = MediumGray)
        }
    }
}