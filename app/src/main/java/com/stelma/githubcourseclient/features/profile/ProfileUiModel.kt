package com.stelma.githubcourseclient.features.profile

import com.stelma.githubcourseclient.R

data class ProfileUiModel(
    val userBasicInfoUiModel: UserBasiInfoUiModel,
    val buttonState: ButtonState,
    val additionalInfoUiModel: ProfileAdditionalInfoUiModel?,
)

enum class ButtonState(
    val textId: Int,
    val iconId: Int,
) {
  SHOW_MORE(
      R.string.show_more,
      R.drawable.ic_baseline_arrow_drop_down_24,
  ),
  SHOW_LESS(
      R.string.show_less,
      R.drawable.ic_baseline_arrow_drop_up_24,
  )
}

data class UserBasiInfoUiModel(
    val userAvatarUrl: String,
    val userFullName: String,
    val username: String,
)

data class ProfileAdditionalInfoUiModel(
    val company: String,
    val blogUrl: String,
    val location: String,
    val twitterUsername: String,
    /**
     * An information about followers count and following count.
     */
    val connectionInfo: String,
)
