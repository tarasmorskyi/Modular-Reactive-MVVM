package com.tarasmorskyi.splash.api

import android.app.Activity

interface SplashUiEvents {

    fun startLoginScreen(activity: Activity)

    fun startMainScreen(activity: Activity)
}