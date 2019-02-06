package com.tarasmorskyi.splash

import com.tarasmorskyi.uicore.BaseViewModelEvent

sealed class SplashViewModelEvent : BaseViewModelEvent {

    object CheckLoginStatus : SplashViewModelEvent()
}