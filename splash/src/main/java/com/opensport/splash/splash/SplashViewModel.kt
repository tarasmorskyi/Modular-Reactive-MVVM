package com.opensport.splash.splash

import io.reactivex.Observable
import io.reactivex.ObservableSource
import com.opensport.splash.splash.interactors.SplashInteractor
import com.opensport.uicore.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject
constructor(private val interactor: SplashInteractor) :
    BaseViewModel<SplashUiModel, SplashViewModelEvent, SplashViewEvent>() {

    override fun onEvent(it: SplashViewModelEvent): ObservableSource<SplashUiModel> {
        TODO("call interactor methods from here without managing results")
    }

    override fun onNext(it: SplashUiModel) {
        TODO("manage events from RX here. Also post data to LiveData and View from here")
    }
}