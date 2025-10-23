package com.tecsup.candidato_info_app.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.tecsup.candidato_info_app.data.model.Noticia
import com.tecsup.candidato_info_app.presentacion.viewmodel.NewsViewModel
import com.tecsup.candidato_info_app.ui.theme.PrimaryBlue
import java.net.URLEncoder

@Composable
fun NewsScreen(
    navController: NavHostController,
    viewModel: NewsViewModel = viewModel()
) {
    val noticias = viewModel.noticias.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Text(
                    "NOTICIAS",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // News List
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(noticias.value) { noticia ->
                NewsCard(noticia)
            }
        }
    }
}

@Composable
fun NewsCard(noticia: Noticia) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color.LightGray)
            ) {
                val encodedTitle = URLEncoder.encode(noticia.titulo, "UTF-8")
                AsyncImage(
                    model = "https://via.placeholder.com/400x200?text=$encodedTitle",

                    contentDescription = noticia.titulo,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            // Content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        noticia.titulo,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2
                    )
                    Text(
                        noticia.descripcion,
                        fontSize = 12.sp,
                        color = Color.Gray,
                        maxLines = 1
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        noticia.fuente,
                        fontSize = 10.sp,
                        color = PrimaryBlue,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        noticia.fecha,
                        fontSize = 10.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}
