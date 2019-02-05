package com.tarasmorskyi.main.api

import android.app.Activity
import com.jakewharton.rxrelay2.Relay


interface MainUiEvents {
    fun goToSplash(activity: Activity)

    val updateNotifier: Relay<Boolean>
}