package com.tarasmorskyi.myapplication.moduleAPIs.repoEvents

import com.tarasmorskyi.dataModel.Constants.EMPTY_STRING
import com.tarasmorskyi.localstorage.LocalRepository
import com.tarasmorskyi.splash.api.SplashRepoEvents
import io.reactivex.Maybe
import javax.inject.Inject

class SplashRepoEventsImpl @Inject internal constructor(
    val local: LocalRepository
) : SplashRepoEvents {

    override fun isLoggedIn(): Maybe<Boolean> {
        return local.userAuthenticationData.map { it.accessToken != EMPTY_STRING }
    }
}