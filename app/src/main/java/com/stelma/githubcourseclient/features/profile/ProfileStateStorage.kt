package com.stelma.githubcourseclient.features.profile

import android.content.SharedPreferences

class ProfileStateStorage(private val sharedPreferences: SharedPreferences) {

  private companion object {
    const val KEY_ADDITIONAL_SCREEN_VISIBLE = "KEY_ADDITIONAL_SCREEN_VISIBLE"
  }

  var isAdditionalScreenVisible: Boolean
    get() {
      return sharedPreferences.getBoolean(KEY_ADDITIONAL_SCREEN_VISIBLE, false)
    }
    set(value) {
      sharedPreferences.edit()
          .putBoolean(KEY_ADDITIONAL_SCREEN_VISIBLE, value)
          .apply()
    }
}