package com.gubo.duszaverseny.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@Composable
fun Theme(content: @Composable () -> Unit) {
    DuszaVersenyTheme(content = content)
}

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF0077B6),
    secondary = Color(0xFF00B4D8),
    tertiary = Color(0xFF90E0EF),
    background = Color(0xFF03045E),
    surface = Color(0xFF023E8A),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.Black,
    onBackground = Color(0xFFCAF0F8),
    onSurface = Color(0xFFADE8F4)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00B4D8),
    secondary = Color(0xFF48CAE4),
    tertiary = Color(0xFFCAF0F8),
    background = Color(0xFFF0F4FF),
    surface = Color(0xFFFFFFFF),
    onPrimary = Color(0xFF03045E),
    onSecondary = Color(0xFF0077B6),
    onTertiary = Color(0xFF023E8A),
    onBackground = Color(0xFF03045E),
    onSurface = Color(0xFF023E8A)
)

@Composable
fun DuszaVersenyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}