package com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs

import android.app.Activity
import com.jakewharton.rxrelay2.PublishRelay
import com.jakewharton.rxrelay2.Relay
import com.tarasmorskyi.main.api.MainUiEvents
import com.tarasmorskyi.splash.SplashActivity
import javax.inject.Inject

class MainUiEventsImpl @Inject constructor() : MainUiEvents {

    override fun goToSplash(activity: Activity) = activity.startActivity(SplashActivity.createIntent(activity))

    override val updateNotifier: Relay<Boolean> = PublishRelay.create()
}