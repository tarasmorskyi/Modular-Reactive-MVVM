package com.tarasmorskyi.main.settings

import com.tarasmorskyi.main.settings.interactors.SettingsInteractor
import com.tarasmorskyi.uicore.BaseViewModel
import io.reactivex.Observable
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val interactor: SettingsInteractor
) : BaseViewModel<SettingsUiModel, SettingsViewModelEvent, SettingsViewEvent>() {

    override fun onEvent(useCase: SettingsViewModelEvent): Observable<out SettingsUiModel> = when (useCase) {

        is SettingsViewModelEvent.GetSettings -> interactor.settings().map { SettingsUiModel.SetSettings(it) }.toObservable()

        is SettingsViewModelEvent.SetSettingsFilter -> interactor.setSettingsFilter(
            useCase.filterId
        ).andThen(Observable.just(SettingsUiModel.NotifyGalleryForUpdate))

        is SettingsViewModelEvent.SetSettingsMature -> interactor.setSettingsMature(
            useCase.mature
        ).andThen(Observable.just(SettingsUiModel.NotifyGalleryForUpdate))

        is SettingsViewModelEvent.SetSettingsShowViral -> interactor.setSettingsShowViral(
            useCase.isViral
        ).andThen(Observable.just(SettingsUiModel.NotifyGalleryForUpdate))

        is SettingsViewModelEvent.Logout -> interactor.logout().andThen(Observable.just(SettingsUiModel.LoggedOut))
    }


    override fun onNext(useCase: SettingsUiModel) = when (useCase) {

        is SettingsUiModel.SetSettings -> viewEventObservable.value =
                SettingsViewEvent.SetupSearchSettings(useCase.searchSettings)

        is SettingsUiModel.LoggedOut -> viewEventObservable.value = SettingsViewEvent.GoToSplash

        is SettingsUiModel.NotifyGalleryForUpdate -> viewEventObservable.value =
                SettingsViewEvent.NotifyGalleryForUpdate
    }
}