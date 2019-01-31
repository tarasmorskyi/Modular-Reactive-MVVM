package com.tarasmorskyi.splash.splash.interactors

import com.tarasmorskyi.splash.api.SplashRepoEvents
import io.reactivex.Maybe
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashInteractorImpl @Inject constructor(val splashRepoEvents: SplashRepoEvents) : SplashInteractor {

    override fun isLoggedIn(): Maybe<Boolean> = splashRepoEvents.isLoggedIn().delay(2, TimeUnit.SECONDS)

}