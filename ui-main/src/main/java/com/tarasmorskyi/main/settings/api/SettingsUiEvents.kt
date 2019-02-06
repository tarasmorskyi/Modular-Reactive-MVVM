package com.tarasmorskyi.main.settings.api

import android.app.Activity
import com.jakewharton.rxrelay2.Relay

interface SettingsUiEvents {

    fun goToSplash(activity: Activity)

    val updateNotifier: Relay<Boolean>
}