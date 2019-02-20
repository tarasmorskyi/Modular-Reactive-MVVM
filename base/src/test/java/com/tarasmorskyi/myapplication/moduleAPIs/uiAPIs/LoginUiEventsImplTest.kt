package com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs

import android.app.Activity
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class LoginUiEventsImplTest {

    lateinit var activity: Activity
    lateinit var loginUiEventsImpl: LoginUiEventsImpl

    @BeforeEach
    fun setUp() {
        activity = mock {  }
        loginUiEventsImpl = LoginUiEventsImpl()
    }

    @Test
    fun startPreviewGalleryScreen() {
        loginUiEventsImpl.startPreviewGalleryScreen(activity)
        verify(activity).startActivity(any())
    }

    @Test
    fun startSplashScreen() {
        loginUiEventsImpl.startSplashScreen(activity)
        verify(activity).startActivity(any())
    }
}