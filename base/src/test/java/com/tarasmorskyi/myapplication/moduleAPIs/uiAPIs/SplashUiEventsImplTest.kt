package com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs

import android.app.Activity
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SplashUiEventsImplTest {

    lateinit var activity: Activity
    lateinit var splashUiEventsImpl: SplashUiEventsImpl

    @BeforeEach
    fun setUp() {
        activity = mock {  }
        splashUiEventsImpl = SplashUiEventsImpl()
    }

    @Test
    fun startMainScreen() {
        splashUiEventsImpl.startMainScreen(activity)
        verify(activity).startActivity(any())
    }

    @Test
    fun startLoginScreen() {
        splashUiEventsImpl.startLoginScreen(activity)
        verify(activity).startActivity(any())
    }
}