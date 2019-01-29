package com.opensport.splash.splash.interactors

import com.opensport.splash.api.SplashRepoEvents
import io.reactivex.Maybe
import javax.inject.Inject

class SplashInteractorImpl @Inject constructor(val splashRepoEvents: SplashRepoEvents) : SplashInteractor {

    override fun isLoggedIn(): Maybe<Boolean> {
        return splashRepoEvents.isLoggedIn()
    }

}