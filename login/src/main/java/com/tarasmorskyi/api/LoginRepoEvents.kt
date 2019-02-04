package com.tarasmorskyi.api

import com.tarasmorskyi.dataModel.UserAuthenticationData
import io.reactivex.Completable

interface LoginRepoEvents {
    fun login(userAuthenticationData: UserAuthenticationData): Completable
}