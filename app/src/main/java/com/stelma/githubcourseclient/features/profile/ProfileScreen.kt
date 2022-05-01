package com.stelma.githubcourseclient.features.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.stelma.githubcourseclient.R

@Composable
fun ProfileScreen() {
  Column(
      modifier = Modifier
          .padding(all = 8.dp)
          .fillMaxWidth(),
  ) {
    ProfileToolbar()

    UserBasicInfo()

    Box(modifier = Modifier.height(48.dp))

    UserAdditionalInfo()
  }
}

@Composable
private fun ProfileToolbar() {
  Box(
      modifier = Modifier
          .height(48.dp)
          .fillMaxWidth(),
  ) {
    AsyncImage(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .align(Alignment.CenterEnd),
        model = R.drawable.ic_baseline_share_24,
        contentDescription = null,
    )
  }
}

@Composable
private fun UserBasicInfo() {
  Row {
    AsyncImage(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .size(64.dp)
            .clip(CircleShape),
        model = "https://avatars.githubusercontent.com/u/12096148",
        contentDescription = null,
    )
    Column(modifier = Modifier.padding(start = 8.dp)) {
      Text(
          text = "Volodymyr Stelmashchuk",
          style = MaterialTheme.typography.h5,
      )
      Text(
          text = "VovaStelmashchuk",
          style = MaterialTheme.typography.subtitle1,
      )
    }
  }
}

@Composable
private fun UserAdditionalInfo() {
  Row {
    Text(
        text = "Parimatch tech",
        style = MaterialTheme.typography.subtitle1,
    )
    Text(
        modifier = Modifier.padding(start = 16.dp),
        text = "Ukraine",
        style = MaterialTheme.typography.subtitle1,
    )
  }
  Text(
      modifier = Modifier.padding(top = 4.dp),
      text = "https://androidstory.buzzsprout.com/",
      style = MaterialTheme.typography.subtitle1,
  )
  Text(
      modifier = Modifier.padding(top = 4.dp),
      text = "vovochkastemashchuk@gmail.com",
      style = MaterialTheme.typography.subtitle1,
  )
  Text(
      modifier = Modifier.padding(top = 4.dp),
      text = "@smallstells",
      style = MaterialTheme.typography.subtitle1,
  )
  Text(
      modifier = Modifier.padding(top = 4.dp),
      text = "26 followers • 9 following",
      style = MaterialTheme.typography.subtitle1,
  )
}