package com.opensport.splash.splash

import com.opensport.uicore.BaseViewEvent

sealed class SplashViewEvent : BaseViewEvent {
    object GoToMain : SplashViewEvent()
    object GoToLogin : SplashViewEvent()
}