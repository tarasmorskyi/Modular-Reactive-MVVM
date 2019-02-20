package com.tarasmorskyi.myapplication.moduleAPIs.repoEvents

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.tarasmorskyi.dataModel.SearchSettings
import com.tarasmorskyi.dataModel.UserAuthenticationData
import com.tarasmorskyi.localstorage.LocalRepository
import io.reactivex.Completable
import io.reactivex.Maybe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SettingsRepoEventsImplTest {

    lateinit var local: LocalRepository
    lateinit var settingsRepoEventsImpl: SettingsRepoEventsImpl

    @BeforeEach
    fun setUp() {
        local = mock {  }
        settingsRepoEventsImpl = SettingsRepoEventsImpl(local)
    }

    @Test
    fun getSettings() {
        val searchSettings = SearchSettings()
        whenever(local.searchSettings).thenReturn(Maybe.just(searchSettings))
        settingsRepoEventsImpl.settings().test().assertValue(searchSettings)
        verify(local).searchSettings
    }

    @Test
    fun getSettingsEmpty() {
        whenever(local.searchSettings).thenReturn(Maybe.empty())
        settingsRepoEventsImpl.settings().test().assertNoValues()
        verify(local).searchSettings
    }

    @Test
    fun setSettings() {
        val searchSettings = SearchSettings()
        whenever(local.setSearchSettings(searchSettings)).thenReturn(Completable.complete())
        settingsRepoEventsImpl.setSettings(searchSettings).test().assertComplete()
        verify(local).setSearchSettings(searchSettings)
    }

    @Test
    fun logout() {
        whenever(local.setUserAuthenticationData(UserAuthenticationData())).thenReturn(Completable.complete())
        settingsRepoEventsImpl.logout().test().assertComplete()
        verify(local).setUserAuthenticationData(UserAuthenticationData())
    }
}