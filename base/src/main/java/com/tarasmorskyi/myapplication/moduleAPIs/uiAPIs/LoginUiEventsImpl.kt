package com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs

import android.app.Activity
import com.opensport.previewgallery.PreviewGalleryActivity
import com.tarasmorskyi.login.api.LoginUiEvents
import com.tarasmorskyi.splash.SplashActivity
import javax.inject.Inject

class LoginUiEventsImpl @Inject internal constructor() : LoginUiEvents {

    override fun startPreviewGalleryScreen(activity: Activity) =
        activity.startActivity(PreviewGalleryActivity.createIntent(activity))

    override fun startSplashScreen(activity: Activity) = activity.startActivity(SplashActivity.createIntent(activity))
}