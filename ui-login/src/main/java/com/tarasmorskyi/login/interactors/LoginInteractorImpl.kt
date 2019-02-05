package com.tarasmorskyi.login.interactors

import com.tarasmorskyi.api.LoginRepoEvents
import com.tarasmorskyi.dataModel.UserAuthenticationData
import io.reactivex.Completable
import javax.inject.Inject

class LoginInteractorImpl @Inject constructor(val loginRepoEvents: LoginRepoEvents) : LoginInteractor {

    override fun login(userAuthenticationData: UserAuthenticationData): Completable =
        loginRepoEvents.login(userAuthenticationData)

}