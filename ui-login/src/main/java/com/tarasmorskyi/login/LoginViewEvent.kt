package com.tarasmorskyi.login

import com.tarasmorskyi.uicore.BaseViewEvent

sealed class LoginViewEvent : BaseViewEvent {
    object GoToSplash: LoginViewEvent()
}