package com.tarasmorskyi.api

import com.tarasmorskyi.data_model.UserAuthenticationData
import io.reactivex.Completable

interface LoginRepoEvents {
    fun login(userAuthenticationData: UserAuthenticationData): Completable
}