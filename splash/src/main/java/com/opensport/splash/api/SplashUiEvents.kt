package com.opensport.splash.api

import android.app.Activity

interface SplashUiEvents {
    fun startLoginScreen(activity: Activity)

    fun startMainScreen(activity: Activity)
}