package com.stelma.githubcourseclient.features.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ProfileScreenState(profileStateStorage: ProfileStateStorage) {

  private var isAdditionalVisible: Boolean = profileStateStorage.isAdditionalScreenVisible
    set(value) {
      field = value
      profileState = createProfileState(value)
    }

  var profileState by mutableStateOf(
      createProfileState(isAdditionalVisible),
  )
    private set

  fun changeState() {
    isAdditionalVisible = !isAdditionalVisible
  }

  private fun createProfileState(isAdditionalInfoVisible: Boolean): ProfileUiModel {
    val additionalInfo = if (isAdditionalInfoVisible) {
      ProfileAdditionalInfoUiModel(
          company = "Parimatch tech",
          blogUrl = "https://androidstory.buzzsprout.com/",
          location = "Ukraine",
          twitterUsername = "@smallstells",
          connectionInfo = "26 followers • 9 following",
      )
    } else {
      null
    }

    return ProfileUiModel(
        userBasicInfoUiModel = UserBasiInfoUiModel(
            userAvatarUrl = "https://avatars.githubusercontent.com/u/12096148",
            userFullName = "Volodymyr Stelmashchuk",
            username = "VovaStelmashchuk",
        ),
        buttonState = if (isAdditionalInfoVisible) ButtonState.SHOW_LESS else ButtonState.SHOW_MORE,
        additionalInfoUiModel = additionalInfo,
    )
  }
}
