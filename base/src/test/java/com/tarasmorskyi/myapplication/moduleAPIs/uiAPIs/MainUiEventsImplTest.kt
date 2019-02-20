package com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs

import android.app.Activity
import com.jakewharton.rxrelay2.PublishRelay
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class MainUiEventsImplTest {

    lateinit var activity: Activity
    lateinit var mainUiEventsImpl: MainUiEventsImpl

    @BeforeEach
    fun setUp() {
        activity = mock {  }
        mainUiEventsImpl = MainUiEventsImpl()
    }

    @Test
    fun goToSplash() {
        mainUiEventsImpl.goToSplash(activity)
        verify(activity).startActivity(any())
    }

    @Test
    fun getUpdateNotifier() {
        val relay = mainUiEventsImpl.updateNotifier
        assert(relay is PublishRelay)
    }
}