package com.tarasmorskyi.main.api

import android.app.Activity
import com.jakewharton.rxrelay2.Relay
import com.tarasmorskyi.main.settings.api.SettingsUiEvents
import javax.inject.Inject


class SettingsUiEventsImpl @Inject constructor(private val mainUiEvents: MainUiEvents)
    : SettingsUiEvents {
    override fun goToSplash(activity: Activity) = mainUiEvents.goToSplash(activity)

    override val updateNotifier: Relay<Boolean> = mainUiEvents.updateNotifier
}