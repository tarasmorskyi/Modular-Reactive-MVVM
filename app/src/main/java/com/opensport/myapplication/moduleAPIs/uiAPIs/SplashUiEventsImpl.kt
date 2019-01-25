package com.opensport.myapplication.moduleAPIs.uiAPIs

import android.app.Activity
import android.content.Intent
import com.opensport.login.ui.LoginActivity
import com.opensport.splash.api.SplashUiEvents
import javax.inject.Inject

class SplashUiEventsImpl @Inject internal constructor(): SplashUiEvents {
    override fun startLoginScreen(activity: Activity) {
        activity.startActivity(Intent(activity, LoginActivity::class.java))
    }
}