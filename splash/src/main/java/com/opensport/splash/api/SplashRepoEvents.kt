package com.opensport.splash.api

import io.reactivex.Maybe

interface SplashRepoEvents {
    fun isLoggedIn(): Maybe<Boolean>
}