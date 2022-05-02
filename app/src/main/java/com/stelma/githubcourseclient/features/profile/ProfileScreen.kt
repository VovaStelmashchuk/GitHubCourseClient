package com.stelma.githubcourseclient.features.profile

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.SharedPreferencesCompat
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

    Spacer(modifier = Modifier.height(4.dp))

    val context = LocalContext.current

    val profileScreenState = remember {
      ProfileScreenState(
          ProfileStateStorage(context.getSharedPreferences("GithubApp", Context.MODE_PRIVATE)),
      )
    }

    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = { profileScreenState.changeState() },
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        val profileState = profileScreenState.profileState
        Text(text = stringResource(id = profileState.buttonTextId))
        Spacer(modifier = Modifier.width(2.dp))
        AsyncImage(
            modifier = Modifier.size(24.dp),
            model = profileState.buttonIconId,
            contentDescription = null,
        )
      }
    }

    if (profileScreenState.profileState.isAdditionalScreenVisible) {
      Spacer(modifier = Modifier.height(8.dp))
      UserAdditionalInfo()
    }
  }
}

@Composable
private fun ProfileToolbar() {
  Box(
      modifier = Modifier
          .height(32.dp)
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
    UserAdditionalInfoItem(
        iconId = R.drawable.ic_baseline_business_24,
        text = "Parimatch tech",
    )

    Spacer(modifier = Modifier.width(4.dp))

    UserAdditionalInfoItem(
        iconId = R.drawable.ic_baseline_location_city_24,
        text = "Ukraine",
    )
  }
  Spacer(modifier = Modifier.height(4.dp))
  UserAdditionalInfoItem(
      iconId = R.drawable.ic_baseline_link_24,
      text = "https://androidstory.buzzsprout.com/",
  )
  Spacer(modifier = Modifier.height(4.dp))
  UserAdditionalInfoItem(
      iconId = R.drawable.ic_baseline_email_24,
      text = "vovochkastemashchuk@gmail.com",
  )
  Spacer(modifier = Modifier.height(4.dp))
  UserAdditionalInfoItem(
      iconId = R.drawable.ic_twitter_logo,
      text = "@smallstells",
  )
  Spacer(modifier = Modifier.height(4.dp))
  UserAdditionalInfoItem(
      iconId = R.drawable.ic_baseline_people_24,
      text = "26 followers • 9 following",
  )
}

@Composable
private fun UserAdditionalInfoItem(iconId: Int, text: String) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    AsyncImage(
        modifier = Modifier
            .size(16.dp),
        model = iconId,
        contentDescription = null,
    )
    Spacer(modifier = Modifier.width(2.dp))
    Text(
        text = text,
        style = MaterialTheme.typography.subtitle1,
    )
  }
}