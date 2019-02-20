package com.tarasmorskyi.myapplication.moduleAPIs.repoEvents

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.tarasmorskyi.dataModel.UserAuthenticationData
import com.tarasmorskyi.localstorage.LocalRepository
import io.reactivex.Maybe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SplashRepoEventsImplTest {

    lateinit var local: LocalRepository
    lateinit var splashRepoEventsImpl: SplashRepoEventsImpl

    @BeforeEach
    fun setUp() {
        local = mock { }
        splashRepoEventsImpl = SplashRepoEventsImpl(local)
    }

    @Test
    fun isLoggedIn() {
        val userAuthenticationData = UserAuthenticationData(accessToken = "token")
        whenever(local.userAuthenticationData).thenReturn(Maybe.just(userAuthenticationData))
        splashRepoEventsImpl.isLoggedIn().test().assertValue(true)
        verify(local).userAuthenticationData
    }

    @Test
    fun isNotLoggedIn() {
        val userAuthenticationData = UserAuthenticationData()
        whenever(local.userAuthenticationData).thenReturn(Maybe.just(userAuthenticationData))
        splashRepoEventsImpl.isLoggedIn().test().assertValue(false)
        verify(local).userAuthenticationData
    }

    @Test
    fun isLoggedInEmpty() {
        whenever(local.userAuthenticationData).thenReturn(Maybe.empty())
        splashRepoEventsImpl.isLoggedIn().test().assertNoValues()
        verify(local).userAuthenticationData
    }
}