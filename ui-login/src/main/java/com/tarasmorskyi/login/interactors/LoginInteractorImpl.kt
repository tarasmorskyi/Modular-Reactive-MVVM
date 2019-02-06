package com.tarasmorskyi.login.interactors

import com.tarasmorskyi.dataModel.UserAuthenticationData
import com.tarasmorskyi.login.api.LoginRepoEvents
import io.reactivex.Completable
import javax.inject.Inject

class LoginInteractorImpl @Inject constructor(
    private val loginRepoEvents: LoginRepoEvents
) : LoginInteractor {

    override fun login(userAuthenticationData: UserAuthenticationData): Completable =
        loginRepoEvents.login(userAuthenticationData)

}