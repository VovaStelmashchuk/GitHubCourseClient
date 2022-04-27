package com.stelma.gitHubcourseclient.features.start

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StartScreen() {
  Surface(modifier = Modifier.fillMaxSize()) {
    Greeting("Android")
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}
