package com.tarasmorskyi.splash.splash.interactors

import io.reactivex.Maybe

interface SplashInteractor {
    fun isLoggedIn(): Maybe<Boolean>
}