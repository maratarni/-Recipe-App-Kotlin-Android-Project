package com.example.reteteapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// CULORI DESCHISE
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFEFDBCD),
    secondary = Color(0xFFD6EFD1),
    tertiary = Color(0xFFE6B89C),
    background = Color.White,
    surface = Color(0xFFFFFBFA),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

// CULORI ÎNCHISE (Dark Mode)
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBFA99A),
    secondary = Color(0xFF9DC3AB),
    tertiary = Color(0xFFCD9169),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
)

@Composable
fun ReteteAppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (useDarkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(),
        content = content
    )
}
