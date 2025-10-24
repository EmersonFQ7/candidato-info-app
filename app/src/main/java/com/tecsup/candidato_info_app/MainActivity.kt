package com.tecsup.candidato_info_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.tecsup.candidato_info_app.data.datasource.VotePersistence
import com.tecsup.candidato_info_app.navigation.AppNavHost
import com.tecsup.candidato_info_app.ui.theme.CandidatoInfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // esto va inicializar la persistencia de votos
        VotePersistence.initialize(this)
        
        setContent {
            CandidatoInfoTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }
}

