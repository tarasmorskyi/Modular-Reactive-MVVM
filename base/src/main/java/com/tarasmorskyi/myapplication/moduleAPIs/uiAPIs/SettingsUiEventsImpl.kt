package com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs

import android.app.Activity
import com.tarasmorskyi.main.settings.api.SettingsUiEvents
import com.tarasmorskyi.splash.splash.SplashActivity
import javax.inject.Inject

class SettingsUiEventsImpl @Inject constructor()
    : SettingsUiEvents {
    override fun goToSplash(activity: Activity) = activity.startActivity(SplashActivity.createIntent(activity))
}