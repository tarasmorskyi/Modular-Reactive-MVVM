package com.tarasmorskyi.myapplication.moduleAPIs.repoEvents

import com.tarasmorskyi.dataModel.UserAuthenticationData
import com.tarasmorskyi.localstorage.LocalRepository
import com.tarasmorskyi.login.api.LoginRepoEvents
import io.reactivex.Completable
import javax.inject.Inject

class LoginRepoEventsImpl @Inject internal constructor(
    private val local: LocalRepository
) : LoginRepoEvents {

    override fun login(userAuthenticationData: UserAuthenticationData): Completable {
        return local.setUserAuthenticationData(userAuthenticationData)
    }

}