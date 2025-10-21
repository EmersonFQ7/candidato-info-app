package com.tecsup.candidato_info_app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = White,
    secondary = SuccessGreen,
    onSecondary = White,
    tertiary = ErrorRed,
    onTertiary = White,
    background = BackgroundLight,
    onBackground = Black,
    surface = SurfaceLight,
    onSurface = DarkGray,
)

@Composable
fun CandidatoInfoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}