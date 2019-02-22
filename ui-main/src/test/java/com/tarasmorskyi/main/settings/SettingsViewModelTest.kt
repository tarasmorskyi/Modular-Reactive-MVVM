package com.tarasmorskyi.main.settings

import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.tarasmorskyi.dataModel.SearchSettings
import com.tarasmorskyi.main.settings.interactors.SettingsInteractor
import com.tarasmorskyi.uicore.BaseViewModelTest
import io.reactivex.Completable
import io.reactivex.Maybe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class SettingsViewModelTest : BaseViewModelTest() {

    lateinit var settingsViewModel: SettingsViewModel
    lateinit var settingsInteractor: SettingsInteractor
    lateinit var viewEventObservable: MutableLiveData<SettingsViewEvent>

    @BeforeEach
    fun setUp() {
        settingsInteractor = mock { }
        settingsViewModel = SettingsViewModel(settingsInteractor)
        viewEventObservable = mock { }
        settingsViewModel.viewEventObservable = viewEventObservable
    }

    @Test
    fun onEventGetSettings() {
        val searchSettings = SearchSettings()
        whenever(settingsInteractor.settings).thenReturn(Maybe.just(searchSettings))
        assert(
            settingsViewModel.onEvent(SettingsViewModelEvent.GetSettings).test().values()[0]
                    ==
                    SettingsUiModel.SetSettings(searchSettings)
        )
        verify(settingsInteractor).settings
    }

    @Test
    fun onEventGetSettingsEmpty() {
        whenever(settingsInteractor.settings).thenReturn(Maybe.empty())
        assert(
            settingsViewModel.onEvent(SettingsViewModelEvent.GetSettings).test().values().isEmpty()
        )
        verify(settingsInteractor).settings
    }

    @Test
    fun onEventSetSettingsMature() {
        whenever(settingsInteractor.setSettingsMature(any())).thenReturn(Completable.complete())
        assert(
            settingsViewModel.onEvent(SettingsViewModelEvent.SetSettingsMature(true)).test().values()[0]
                    ==
                    SettingsUiModel.NotifyGalleryForUpdate
        )
        verify(settingsInteractor).setSettingsMature(any())
    }

    @Test
    fun onEventSetSettingsShowViral() {
        whenever(settingsInteractor.setSettingsShowViral(any())).thenReturn(Completable.complete())
        assert(
            settingsViewModel.onEvent(SettingsViewModelEvent.SetSettingsShowViral(true)).test().values()[0]
                    ==
                    SettingsUiModel.NotifyGalleryForUpdate
        )
        verify(settingsInteractor).setSettingsShowViral(any())
    }

    @Test
    fun onEventSetSettingsFilter() {
        whenever(settingsInteractor.setSettingsFilter(any())).thenReturn(Completable.complete())
        assert(
            settingsViewModel.onEvent(SettingsViewModelEvent.SetSettingsFilter(0)).test().values()[0]
                    ==
                    SettingsUiModel.NotifyGalleryForUpdate
        )
        verify(settingsInteractor).setSettingsFilter(any())
    }

    @Test
    fun onEventLogout() {
        whenever(settingsInteractor.logout()).thenReturn(Completable.complete())
        assert(
            settingsViewModel.onEvent(SettingsViewModelEvent.Logout).test().values()[0]
                    ==
                    SettingsUiModel.LoggedOut
        )
        verify(settingsInteractor).logout()
    }

    @Test
    fun onNextSetSettings() {
        val searchSettings = SearchSettings()
        settingsViewModel.onNext(SettingsUiModel.SetSettings(searchSettings))
        verify(viewEventObservable).value = SettingsViewEvent.SetupSearchSettings(searchSettings)
    }

    @Test
    fun onNextLoggedOut() {
        settingsViewModel.onNext(SettingsUiModel.LoggedOut)
        verify(viewEventObservable).value = SettingsViewEvent.GoToSplash
    }

    @Test
    fun onNextNotifyGalleryForUpdate() {
        settingsViewModel.onNext(SettingsUiModel.NotifyGalleryForUpdate)
        verify(viewEventObservable).value = SettingsViewEvent.NotifyGalleryForUpdate
    }
}