package com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs

import android.app.Activity
import android.content.Intent
import com.tarasmorskyi.login.LoginActivity
import com.tarasmorskyi.splash.api.SplashUiEvents
import javax.inject.Inject

class SplashUiEventsImpl @Inject internal constructor(): SplashUiEvents {
    override fun startMainScreen(activity: Activity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startLoginScreen(activity: Activity) {
        activity.startActivity(Intent(activity, LoginActivity::class.java))
    }
}