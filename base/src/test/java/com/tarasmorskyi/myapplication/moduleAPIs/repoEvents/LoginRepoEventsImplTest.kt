package com.tarasmorskyi.myapplication.moduleAPIs.repoEvents

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.tarasmorskyi.dataModel.UserAuthenticationData
import com.tarasmorskyi.localstorage.LocalRepository
import io.reactivex.Completable
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class LoginRepoEventsImplTest {

    lateinit var local: LocalRepository
    lateinit var loginRepoEventsImpl: LoginRepoEventsImpl

    @BeforeEach
    fun setUp() {
        local = mock {  }
        loginRepoEventsImpl = LoginRepoEventsImpl(local)
    }

    @Test
    fun login() {
        val userAuthenticationData = UserAuthenticationData()
        whenever(local.setUserAuthenticationData(userAuthenticationData)).thenReturn(Completable.complete())
        loginRepoEventsImpl.login(userAuthenticationData).test().assertComplete()
        verify(local).setUserAuthenticationData(userAuthenticationData)
    }
}