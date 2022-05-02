package com.stelma.githubcourseclient.features.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stelma.githubcourseclient.R

data class ProfileUiModel(
    val isAdditionalScreenVisible: Boolean,
    val buttonTextId: Int,
    val buttonIconId: Int,
)

class ProfileScreenState(private val profileStateStorage: ProfileStateStorage) {

  var profileState by mutableStateOf(
      createProfileState(profileStateStorage.isAdditionalScreenVisible),
  )
    private set

  fun changeState() {
    profileState = createProfileState(!profileState.isAdditionalScreenVisible)
    profileStateStorage.isAdditionalScreenVisible = profileState.isAdditionalScreenVisible
  }

  private fun createProfileState(isAdditionalInfoVisible: Boolean): ProfileUiModel {
    return if (isAdditionalInfoVisible) {
      buildExpandProfileState()
    } else {
      buildCollapsedProfileState()
    }
  }

  private fun buildExpandProfileState(): ProfileUiModel {
    return ProfileUiModel(
        true,
        R.string.show_less,
        R.drawable.ic_baseline_arrow_drop_up_24,
    )
  }

  private fun buildCollapsedProfileState(): ProfileUiModel {
    return ProfileUiModel(
        false,
        R.string.show_more,
        R.drawable.ic_baseline_arrow_drop_down_24,
    )
  }
}
