package com.tarasmorskyi.main.settings

import com.tarasmorskyi.main.settings.interactors.SettingsInteractor
import com.tarasmorskyi.uicore.BaseViewModel
import io.reactivex.ObservableSource
import javax.inject.Inject

class SettingsViewModel @Inject constructor(private val interactor: SettingsInteractor) :
    BaseViewModel<SettingsUiModel, SettingsViewModelEvent, SettingsViewEvent>() {

    override fun onEvent(it: SettingsViewModelEvent): ObservableSource<SettingsUiModel> {
        TODO("call interactor methods from here without managing results")
    }

    override fun onNext(it: SettingsUiModel) {
        TODO("manage events from RX here. Also post data to LiveData and View from here")
    }
}