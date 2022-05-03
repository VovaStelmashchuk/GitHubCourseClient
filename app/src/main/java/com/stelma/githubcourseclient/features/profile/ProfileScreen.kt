package com.stelma.githubcourseclient.features.profile

import android.content.Context
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

    val profileScreenState = rememberProfileScreenState()

    UserBasicInfo(profileScreenState.profileState.userBasicInfoUiModel)

    Spacer(modifier = Modifier.height(4.dp))

    AdditionalControlButton(
        profileScreenState.profileState.buttonState,
        profileScreenState::changeState,
    )

    profileScreenState.profileState.additionalInfoUiModel?.let {
      Spacer(modifier = Modifier.height(8.dp))
      UserAdditionalInfo(it)
    }
  }
}

@Composable
private fun AdditionalControlButton(buttonState: ButtonState, onClick: () -> Unit) {
  Button(
      modifier = Modifier.fillMaxWidth(),
      onClick = { onClick() },
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Text(text = stringResource(id = buttonState.textId))
      Spacer(modifier = Modifier.width(2.dp))
      AsyncImage(
          modifier = Modifier.size(24.dp),
          model = buttonState.iconId,
          contentDescription = null,
      )
    }
  }
}

@Composable
private fun rememberProfileScreenState(): ProfileScreenState {
  val context = LocalContext.current
  return remember {
    ProfileScreenState(
        ProfileStateStorage(context.getSharedPreferences("GithubApp", Context.MODE_PRIVATE)),
    )
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
private fun UserBasicInfo(userBasiInfoUiModel: UserBasiInfoUiModel) {
  Row {
    AsyncImage(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .size(64.dp)
            .clip(CircleShape),
        model = userBasiInfoUiModel.userAvatarUrl,
        contentDescription = null,
    )
    Column(modifier = Modifier.padding(start = 8.dp)) {
      Text(
          text = userBasiInfoUiModel.userFullName,
          style = MaterialTheme.typography.h5,
      )
      Text(
          text = userBasiInfoUiModel.username,
          style = MaterialTheme.typography.subtitle1,
      )
    }
  }
}

@Composable
private fun UserAdditionalInfo(profileAdditionalInfoUiModel: ProfileAdditionalInfoUiModel) {
  Row {
    UserAdditionalInfoItem(
        iconId = R.drawable.ic_baseline_business_24,
        text = profileAdditionalInfoUiModel.company,
    )

    Spacer(modifier = Modifier.width(4.dp))

    UserAdditionalInfoItem(
        iconId = R.drawable.ic_baseline_location_city_24,
        text = profileAdditionalInfoUiModel.location,
    )
  }
  Spacer(modifier = Modifier.height(4.dp))
  UserAdditionalInfoItem(
      iconId = R.drawable.ic_baseline_link_24,
      text = profileAdditionalInfoUiModel.blogUrl,
  )
  Spacer(modifier = Modifier.height(4.dp))
  UserAdditionalInfoItem(
      iconId = R.drawable.ic_twitter_logo,
      text = profileAdditionalInfoUiModel.twitterUsername,
  )
  Spacer(modifier = Modifier.height(4.dp))
  UserAdditionalInfoItem(
      iconId = R.drawable.ic_baseline_people_24,
      text = profileAdditionalInfoUiModel.connectionInfo,
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