package com.tarasmorskyi.splash

import com.tarasmorskyi.uicore.BaseViewEvent

sealed class SplashViewEvent : BaseViewEvent {

    object GoToMain : SplashViewEvent()

    object GoToLogin : SplashViewEvent()
}