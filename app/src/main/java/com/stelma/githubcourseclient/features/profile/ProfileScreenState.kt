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

class ProfileScreenState {

  var profileState by mutableStateOf(buildCollapsedProfileState())
    private set

  fun changeState() {
    profileState = if (profileState.isAdditionalScreenVisible) {
      buildCollapsedProfileState()
    } else {
      buildExpandProfileState()
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
