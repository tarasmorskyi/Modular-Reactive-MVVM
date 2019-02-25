package com.tarasmorskyi.main.settings.interactors

import com.nhaarman.mockitokotlin2.*
import com.tarasmorskyi.dataModel.SearchSettings
import com.tarasmorskyi.main.R
import com.tarasmorskyi.main.settings.api.SettingsRepoEvents
import com.tarasmorskyi.uicore.BaseViewModelTest
import io.reactivex.Completable
import io.reactivex.Maybe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class SettingsInteractorImplTest : BaseViewModelTest() {

    lateinit var settingsRepoEvents: SettingsRepoEvents
    lateinit var settingsInteractorImpl: SettingsInteractorImpl

    @BeforeEach
    fun setUp() {
        settingsRepoEvents = mock { }
        settingsInteractorImpl = SettingsInteractorImpl(settingsRepoEvents)
    }

    @Test
    fun getSettings() {
        val searchSettings = SearchSettings()
        whenever(settingsRepoEvents.settings()).thenReturn(Maybe.just(searchSettings))
        settingsInteractorImpl.settings().test().assertResult(searchSettings)
        verify(settingsRepoEvents).settings()

    }

    @Test
    fun setSettingsMatureChanged() {
        val searchSettings = SearchSettings(mature = false)
        whenever(settingsRepoEvents.settings()).thenReturn(Maybe.just(searchSettings))
        whenever(settingsRepoEvents.setSettings(searchSettings)).thenReturn(Completable.complete())
        settingsInteractorImpl.setSettingsMature(true).test().assertComplete()
        verify(settingsRepoEvents).settings()
        verify(settingsRepoEvents).setSettings(SearchSettings(mature = true))
        verify(settingsRepoEvents).setSettings(any())
    }

    @Test
    fun setSettingsMatureTheSame() {
        val searchSettings = SearchSettings(mature = true)
        whenever(settingsRepoEvents.settings()).thenReturn(Maybe.just(searchSettings))
        whenever(settingsRepoEvents.setSettings(searchSettings)).thenReturn(Completable.complete())
        settingsInteractorImpl.setSettingsMature(true).test().assertComplete()
        verify(settingsRepoEvents).settings()
        verify(settingsRepoEvents, never()).setSettings(SearchSettings(mature = true))
        verify(settingsRepoEvents, never()).setSettings(any())
    }

    @Test
    fun setSettingsShowViralChanged() {
        val searchSettings = SearchSettings(showViral = false)
        whenever(settingsRepoEvents.settings()).thenReturn(Maybe.just(searchSettings))
        whenever(settingsRepoEvents.setSettings(searchSettings)).thenReturn(Completable.complete())
        settingsInteractorImpl.setSettingsShowViral(true).test().assertComplete()
        verify(settingsRepoEvents).settings()
        verify(settingsRepoEvents).setSettings(SearchSettings(showViral = true))
        verify(settingsRepoEvents).setSettings(any())
    }

    @Test
    fun setSettingsShowViralTheSame() {
        val searchSettings = SearchSettings(showViral = true)
        whenever(settingsRepoEvents.settings()).thenReturn(Maybe.just(searchSettings))
        whenever(settingsRepoEvents.setSettings(searchSettings)).thenReturn(Completable.complete())
        settingsInteractorImpl.setSettingsShowViral(true).test().assertComplete()
        verify(settingsRepoEvents).settings()
        verify(settingsRepoEvents, never()).setSettings(SearchSettings(showViral = true))
        verify(settingsRepoEvents, never()).setSettings(any())
    }

    companion object {
        @JvmStatic
        fun settingsProviderChanged() = listOf(
            Arguments.of(SearchSettings(section = SearchSettings.USER), R.id.hot, SearchSettings(section = SearchSettings.HOT)),
            Arguments.of(SearchSettings(section = SearchSettings.HOT), R.id.top, SearchSettings(section = SearchSettings.TOP)),
            Arguments.of(SearchSettings(section = SearchSettings.HOT), R.id.user, SearchSettings(section = SearchSettings.USER)),

            Arguments.of(SearchSettings(sort = SearchSettings.TOP), R.id.viral, SearchSettings(sort = SearchSettings.VIRAL)),
            Arguments.of(SearchSettings(sort = SearchSettings.VIRAL), R.id.topSort, SearchSettings(sort = SearchSettings.TOP)),
            Arguments.of(SearchSettings(sort = SearchSettings.VIRAL), R.id.time, SearchSettings(sort = SearchSettings.TIME)),

            Arguments.of(SearchSettings(window = SearchSettings.WEEK), R.id.day, SearchSettings(window = SearchSettings.DAY)),
            Arguments.of(SearchSettings(window = SearchSettings.DAY), R.id.week, SearchSettings(window = SearchSettings.WEEK)),
            Arguments.of(SearchSettings(window = SearchSettings.DAY), R.id.month, SearchSettings(window = SearchSettings.MONTH)),
            Arguments.of(SearchSettings(window = SearchSettings.DAY), R.id.year, SearchSettings(window = SearchSettings.YEAR)),
            Arguments.of(SearchSettings(window = SearchSettings.DAY), R.id.all, SearchSettings(window = SearchSettings.ALL))
        )
        @JvmStatic
        fun settingsProviderTheSame() = listOf(
            Arguments.of(SearchSettings(section = SearchSettings.HOT), R.id.hot, SearchSettings(section = SearchSettings.HOT)),
            Arguments.of(SearchSettings(section = SearchSettings.TOP), R.id.top, SearchSettings(section = SearchSettings.TOP)),
            Arguments.of(SearchSettings(section = SearchSettings.USER), R.id.user, SearchSettings(section = SearchSettings.USER)),

            Arguments.of(SearchSettings(sort = SearchSettings.VIRAL), R.id.viral, SearchSettings(sort = SearchSettings.VIRAL)),
            Arguments.of(SearchSettings(sort = SearchSettings.TOP), R.id.topSort, SearchSettings(sort = SearchSettings.TOP)),
            Arguments.of(SearchSettings(sort = SearchSettings.TIME), R.id.time, SearchSettings(sort = SearchSettings.TIME)),

            Arguments.of(SearchSettings(window = SearchSettings.DAY), R.id.day, SearchSettings(window = SearchSettings.DAY)),
            Arguments.of(SearchSettings(window = SearchSettings.WEEK), R.id.week, SearchSettings(window = SearchSettings.WEEK)),
            Arguments.of(SearchSettings(window = SearchSettings.MONTH), R.id.month, SearchSettings(window = SearchSettings.MONTH)),
            Arguments.of(SearchSettings(window = SearchSettings.YEAR), R.id.year, SearchSettings(window = SearchSettings.YEAR)),
            Arguments.of(SearchSettings(window = SearchSettings.ALL), R.id.all, SearchSettings(window = SearchSettings.ALL))
        )
    }

    @ParameterizedTest(name = "{index} => input({0}) should return {2}")
    @MethodSource("settingsProviderChanged")
    fun setSettingsFilterChanged(searchSettings: SearchSettings, filterId: Int, resultSettings: SearchSettings) {
        whenever(settingsRepoEvents.settings()).thenReturn(Maybe.just(searchSettings))
        whenever(settingsRepoEvents.setSettings(any())).thenReturn(Completable.complete())
        settingsInteractorImpl.setSettingsFilter(filterId).test().assertComplete()
        verify(settingsRepoEvents).setSettings(resultSettings)
    }

    @ParameterizedTest(name = "{index} => input({0}) should not change settings")
    @MethodSource("settingsProviderTheSame")
    fun setSettingsFilterTheSame(searchSettings: SearchSettings, filterId: Int, resultSettings: SearchSettings) {
        whenever(settingsRepoEvents.settings()).thenReturn(Maybe.just(searchSettings))
        whenever(settingsRepoEvents.setSettings(any())).thenReturn(Completable.complete())
        settingsInteractorImpl.setSettingsFilter(filterId).test().assertComplete()
        verify(settingsRepoEvents, never()).setSettings(any())
    }


    @Test
    fun logout() {
        whenever(settingsRepoEvents.logout()).thenReturn(Completable.complete())
        settingsInteractorImpl.logout().test().assertComplete()
        verify(settingsRepoEvents).logout()
    }
}