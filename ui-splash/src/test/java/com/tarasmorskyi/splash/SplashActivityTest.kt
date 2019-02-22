package com.tarasmorskyi.splash

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.tarasmorskyi.splash.api.SplashUiEvents
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SplashActivityTest {

    lateinit var splashActivity: SplashActivity
    lateinit var splashUiEvents: SplashUiEvents

    @BeforeEach
    fun setUp() {
        splashActivity = SplashActivity()
        splashUiEvents = mock { }
        splashActivity.splashUiEvents = splashUiEvents
    }

    @Test
    fun onEventGoToLogin() {
        splashActivity.onEvent(SplashViewEvent.GoToLogin)
        verify(splashUiEvents).startLoginScreen(splashActivity)
    }

    @Test
    fun onEventGoToMain() {
        splashActivity.onEvent(SplashViewEvent.GoToMain)
        verify(splashUiEvents).startMainScreen(splashActivity)
    }
}