package com.tecsup.candidato_info_app.presentacion.screens

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tecsup.candidato_info_app.R
import com.tecsup.candidato_info_app.ui.theme.PrimaryBlue
import com.tecsup.candidato_info_app.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(true) {
        delay(2000) // 2 segundos
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.logoprincipal),
                contentDescription = "Logo",
                modifier = Modifier.size(210.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}
