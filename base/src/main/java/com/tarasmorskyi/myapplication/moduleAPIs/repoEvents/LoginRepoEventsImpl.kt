package com.tarasmorskyi.myapplication.moduleAPIs.repoEvents

import com.tarasmorskyi.api.LoginRepoEvents
import com.tarasmorskyi.dataModel.UserAuthenticationData
import com.tarasmorskyi.localstorage.LocalRepository
import io.reactivex.Completable
import javax.inject.Inject

class LoginRepoEventsImpl @Inject internal constructor(
    val local: LocalRepository
) : LoginRepoEvents {

    override fun login(userAuthenticationData: UserAuthenticationData): Completable {
        return local.setUserAuthenticationData(userAuthenticationData)
    }

}