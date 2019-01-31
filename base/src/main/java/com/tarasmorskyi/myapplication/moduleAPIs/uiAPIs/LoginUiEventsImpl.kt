package com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs

import android.app.Activity
import com.tarasmorskyi.api.LoginUiEvents
import com.tarasmorskyi.splash.splash.SplashActivity
import javax.inject.Inject

class LoginUiEventsImpl @Inject internal constructor() : LoginUiEvents {
    override fun startSplashScreen(activity: Activity) {
        activity.startActivity(SplashActivity.createIntent(activity))
    }
}