package com.stelma.githubcourseclient.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.stelma.githubcourseclient.features.start.StartScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      GithubAppTheme {
        StartScreen()
      }
    }
  }
}
