package com.tarasmorskyi.login.interactors

import com.tarasmorskyi.data_model.UserAuthenticationData
import io.reactivex.Completable

interface LoginInteractor {
    fun login(userAuthenticationData: UserAuthenticationData): Completable
}