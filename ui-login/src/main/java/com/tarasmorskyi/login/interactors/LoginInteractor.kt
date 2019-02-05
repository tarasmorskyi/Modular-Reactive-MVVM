package com.tarasmorskyi.login.interactors

import com.tarasmorskyi.dataModel.UserAuthenticationData
import io.reactivex.Completable

interface LoginInteractor {
    fun login(userAuthenticationData: UserAuthenticationData): Completable
}