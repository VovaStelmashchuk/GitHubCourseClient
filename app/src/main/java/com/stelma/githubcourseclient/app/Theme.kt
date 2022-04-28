package com.stelma.githubcourseclient.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Color(0xFF2D6503),
    primaryVariant = Color(0xFF8DC463),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF78DA70),
    secondaryVariant = Color(0xFF007812),
    onSecondary = Color(0xFF000000),
    background = Color(0xFF000000),
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFF000000),
    onSurface = Color(0xFFFFFFFF),
    error = Color(0xFFB00020),
    onError = Color(0xFFFFFFFF),
)

private val LightColorPalette = lightColors(
    primary = Color(0xFF2D6503),
    primaryVariant = Color(0xFF8DC463),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF78DA70),
    secondaryVariant = Color(0xFF007812),
    onSecondary = Color(0xFF000000),
    background = Color(0xFFFFFFFF),
    onBackground = Color(0xFF000000),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF000000),
    error = Color(0xFFB00020),
    onError = Color(0xFFFFFFFF),
)

@Composable
fun GithubAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
  val colors = if (darkTheme) {
    DarkColorPalette
  } else {
    LightColorPalette
  }

  MaterialTheme(
      colors = colors,
      typography = Typography(),
      shapes = Shapes(),
      content = content
  )
}