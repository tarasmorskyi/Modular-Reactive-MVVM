package com.tarasmorskyi.login.api

import android.app.Activity

interface LoginUiEvents {

    fun startSplashScreen(activity: Activity)

    fun startPreviewGalleryScreen(activity: Activity)
}