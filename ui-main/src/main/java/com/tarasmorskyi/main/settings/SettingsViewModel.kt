package com.tarasmorskyi.main.settings

import com.tarasmorskyi.main.settings.interactors.SettingsInteractor
import com.tarasmorskyi.uicore.BaseViewModel
import io.reactivex.Observable
import io.reactivex.ObservableSource
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val interactor: SettingsInteractor
) : BaseViewModel<SettingsUiModel, SettingsViewModelEvent, SettingsViewEvent>() {

    override fun onEvent(useCase: SettingsViewModelEvent): ObservableSource<out SettingsUiModel> = when (useCase) {

        is SettingsViewModelEvent.GetSettings -> interactor.settings.map { SettingsUiModel.SetSettings(it) }.toObservable()

        is SettingsViewModelEvent.SetSettingsFilter -> interactor.setSettingsFilter(
            useCase.filterId
        ).andThen(Observable.just(SettingsUiModel.EnableSearchSettings))

        is SettingsViewModelEvent.SetSettingsMature -> interactor.setSettingsMature(
            useCase.mature
        ).andThen(Observable.just(SettingsUiModel.EnableSearchSettings))

        is SettingsViewModelEvent.SetSettingsShowViral -> interactor.setSettingsShowViral(
            useCase.isViral
        ).andThen(Observable.just(SettingsUiModel.EnableSearchSettings))

        is SettingsViewModelEvent.Logout -> interactor.logout().andThen(Observable.just(SettingsUiModel.LoggedOut))
    }


    override fun onNext(useCase: SettingsUiModel) = when (useCase) {

        is SettingsUiModel.SetSettings -> viewEventObservable.postValue(
            SettingsViewEvent.SetupSearchSettings(useCase.searchSettings)
        )

        is SettingsUiModel.LoggedOut -> viewEventObservable.value = SettingsViewEvent.GoToSplash

        is SettingsUiModel.EnableSearchSettings -> viewEventObservable.value = SettingsViewEvent.NotifyGalleryForUpdate
    }
}