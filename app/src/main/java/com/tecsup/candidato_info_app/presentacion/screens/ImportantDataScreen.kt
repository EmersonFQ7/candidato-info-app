package com.tecsup.candidato_info_app.presentacion.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.tecsup.candidato_info_app.data.datasource.LocalDataSource
import com.tecsup.candidato_info_app.ui.theme.PrimaryBlue
import com.tecsup.candidato_info_app.R
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun ImportantDataScreen(navController: NavHostController) {
    val datosImportantes = LocalDataSource.getDatosImportantes()
    val expandedStates = remember { mutableStateMapOf<String, Boolean>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
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
                    "DATOS IMPORTANTES",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
            }
        }

         Column(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Elecciones Generales",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Perú 2026",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(datosImportantes) { dato ->
                AccordionItem(
                    datoId = dato.id,
                    titulo = dato.titulo,
                    contenido = dato.contenido,
                    isExpanded = expandedStates[dato.id] ?: false,
                    onToggle = {
                        expandedStates[dato.id] = !(expandedStates[dato.id] ?: false)
                    }
                )
            }
        }
    }
}

@Composable
fun RowConIcono(
    iconoResId: Int,
    texto: String,
    fontSize: TextUnit = 12.sp,
    color: Color = Color.Gray
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(id = iconoResId),
            contentDescription = texto,
            modifier = Modifier.size(40.dp)
        )
        Text(
            texto,
            fontSize = fontSize,
            color = color,
            lineHeight = 18.sp
        )
    }
}


@Composable
fun AccordionItem(
    datoId: String,
    titulo: String,
    contenido: String,
    isExpanded: Boolean,
    onToggle: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                onToggle()
            }

            .padding(vertical = 8.dp)
    ) {
        // Fila principal con título y flecha
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                titulo,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = "Expand",
                tint = PrimaryBlue
            )
        }

        // Línea divisoria si no está desplegado
        if (!isExpanded) {
            Divider(color = Color(0xFFDDDDDD), thickness = 1.dp)
        }

        // Contenido cuando está desplegado
        if (isExpanded) {
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                when (datoId) {
                    "dato_1" -> { // Qué se elige
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(12.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                IconoConTexto(
                                    iconoResId = R.drawable.presidente,
                                    titulo = "1",
                                    subtitulo = "Presidente de la República",
                                    iconSize = 85.dp
                                )
                                IconoConTexto(
                                    iconoResId = R.drawable.vicepresidentes,
                                    titulo = "2",
                                    subtitulo = "Vicepresidentes",
                                    iconSize = 100.dp
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(
                                verticalArrangement = Arrangement.spacedBy(12.dp),
                                modifier = Modifier.weight(1f)
                            ) {
                                IconoConTexto(
                                    iconoResId = R.drawable.senadores,
                                    titulo = "60",
                                    subtitulo = "Senadores",
                                    iconSize = 100.dp
                                )
                                IconoConTexto(
                                    iconoResId = R.drawable.diputados,
                                    titulo = "130",
                                    subtitulo = "Diputados",
                                    iconSize = 100.dp
                                )
                                IconoConTexto(
                                    iconoResId = R.drawable.parlamentarios,
                                    titulo = "5",
                                    subtitulo = "Parlamentarios andinos",
                                    iconSize = 55.dp
                                )
                            }
                        }
                    }

                    "dato_2" -> { // Fecha y hora (en dos columnas)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(id = R.drawable.fecha),
                                    contentDescription = "Fecha",
                                    modifier = Modifier.size(60.dp)
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("12 de abril de 2026", fontSize = 14.sp, color = Color.Black)
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(id = R.drawable.hora),
                                    contentDescription = "Hora",
                                    modifier = Modifier.size(60.dp)
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text("7:00 a.m. - 5:00 p.m.", fontSize = 14.sp, color = Color.Black)
                            }
                        }
                    }

                    "dato_3" -> { // Quiénes votan
                        RowConIcono(R.drawable.persona, "Todos los ciudadanos mayores de 18 años",fontSize = 14.sp, color = Color.Black)
                        Spacer(modifier = Modifier.height(4.dp))
                        RowConIcono(R.drawable.adultomayor, "Personas mayores de 70 años",fontSize = 14.sp, color = Color.Black)
                        Spacer(modifier = Modifier.height(4.dp))
                        RowConIcono(R.drawable.adicional, "A partir de los 70 años, el voto es facultativo (opcional).",fontSize = 14.sp, color = Color.Black)
                    }

                    "dato_4" -> { // Recomendaciones

                            RecomendacionesPildoras(contenido)

                    }

                    else -> {
                        Text(
                            contenido,
                            fontSize = 12.sp,
                            color = Color.Gray,
                            lineHeight = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RecomendacionesPildoras(contenido: String) {
    // Separa cada recomendación por salto de línea
    val recomendaciones = contenido.split("\n• ").map { it.replace("• ", "") }

    FlowRow(
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        recomendaciones.forEach { recomendacion ->
            Box(
                modifier = Modifier
                    .background(Color(0xFFE8EDF6), RoundedCornerShape(16.dp))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = recomendacion,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun IconoConTexto(
    iconoResId: Int,
    titulo: String,
    subtitulo: String,
    iconSize: Dp = 60.dp
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFE8EDF6)) // azul claro
            .padding(vertical = 16.dp, horizontal = 8.dp)
    ) {
        Image(
            painter = painterResource(id = iconoResId),
            contentDescription = subtitulo,
            modifier = Modifier.size(iconSize)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = titulo,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = subtitulo,
            fontSize = 12.sp,
            color = Color.Black,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            lineHeight = 16.sp
        )
    }
}

