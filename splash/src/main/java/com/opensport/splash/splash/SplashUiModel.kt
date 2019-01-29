package com.opensport.splash.splash

import com.opensport.uicore.BaseUiModel

sealed class SplashUiModel : BaseUiModel {
    data class LoginResult(val loggedIn: Boolean) : SplashUiModel()
}