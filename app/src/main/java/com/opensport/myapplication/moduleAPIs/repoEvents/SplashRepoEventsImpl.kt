package com.opensport.myapplication.moduleAPIs.repoEvents

import com.opensport.data_model.Constants.EMPTY_STRING
import com.opensport.localstorage.LocalRepository
import com.opensport.splash.api.SplashRepoEvents
import io.reactivex.Maybe
import javax.inject.Inject

class SplashRepoEventsImpl @Inject internal constructor(
    val local: LocalRepository
) : SplashRepoEvents {

    override fun isLoggedIn(): Maybe<Boolean> {
        return local.userAuthenticationData.map { it.accessToken != EMPTY_STRING }
    }
}