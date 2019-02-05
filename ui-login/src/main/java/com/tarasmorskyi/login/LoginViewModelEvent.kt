package com.tarasmorskyi.login

import com.tarasmorskyi.dataModel.UserAuthenticationData
import com.tarasmorskyi.uicore.BaseViewModelEvent

sealed class LoginViewModelEvent : BaseViewModelEvent {
    data class Login(val userAuthenticationData: UserAuthenticationData): LoginViewModelEvent()
}