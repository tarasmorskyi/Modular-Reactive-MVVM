package com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs

import android.app.Activity
import com.tarasmorskyi.main.MainActivity
import com.tarasmorskyi.login.LoginActivity
import com.tarasmorskyi.splash.api.SplashUiEvents
import javax.inject.Inject

class SplashUiEventsImpl @Inject internal constructor(): SplashUiEvents {
    override fun startMainScreen(activity: Activity) {
        activity.startActivity(MainActivity.createIntent(activity))
    }

    override fun startLoginScreen(activity: Activity) {
        activity.startActivity(LoginActivity.createIntent(activity))
    }
}