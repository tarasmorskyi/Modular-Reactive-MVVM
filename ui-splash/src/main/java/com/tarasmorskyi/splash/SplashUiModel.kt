package com.tarasmorskyi.splash

import com.tarasmorskyi.uicore.BaseUiModel

sealed class SplashUiModel : BaseUiModel {

    data class LoginResult(val loggedIn: Boolean) : SplashUiModel()
}