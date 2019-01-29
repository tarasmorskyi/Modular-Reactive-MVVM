package com.opensport.splash.splash

import com.opensport.uicore.BaseViewModelEvent

sealed class SplashViewModelEvent : BaseViewModelEvent {
    object CheckLoginStatus : SplashViewModelEvent()
}