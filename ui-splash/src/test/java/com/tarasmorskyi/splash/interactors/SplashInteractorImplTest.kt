package com.tarasmorskyi.splash.interactors

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.tarasmorskyi.splash.api.SplashRepoEvents
import io.reactivex.Maybe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SplashInteractorImplTest {

    lateinit var splashInteractorImpl: SplashInteractorImpl
    lateinit var splashRepoEvents: SplashRepoEvents

    @BeforeEach
    fun setUp() {
        splashRepoEvents = mock {  }
        splashInteractorImpl = SplashInteractorImpl(splashRepoEvents)
    }

    @Test
    fun isLoggedIn() {
        whenever(splashRepoEvents.isLoggedIn()).thenReturn(Maybe.just(true))
        assert(splashInteractorImpl.isLoggedIn().test().awaitTerminalEvent())
        verify(splashRepoEvents).isLoggedIn()
    }

    @Test
    fun isLoggedInEmpty() {
        whenever(splashRepoEvents.isLoggedIn()).thenReturn(Maybe.empty())
        splashInteractorImpl.isLoggedIn().test().assertNoValues()
        verify(splashRepoEvents).isLoggedIn()
    }
}