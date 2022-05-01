package com.stelma.githubcourseclient.app

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val ColorPalette = Colors(
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
    isLight = false,
)

@Composable
fun GithubAppTheme(content: @Composable () -> Unit) {
  MaterialTheme(
      colors = ColorPalette,
      typography = Typography(),
      shapes = Shapes(),
      content = content,
  )
}