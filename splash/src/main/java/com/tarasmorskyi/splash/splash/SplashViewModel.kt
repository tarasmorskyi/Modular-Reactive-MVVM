package com.tarasmorskyi.splash.splash

import com.tarasmorskyi.splash.splash.interactors.SplashInteractor
import com.tarasmorskyi.uicore.BaseViewModel
import io.reactivex.ObservableSource
import javax.inject.Inject

class SplashViewModel @Inject
constructor(private val interactor: SplashInteractor) :
    BaseViewModel<SplashUiModel, SplashViewModelEvent, SplashViewEvent>() {

    override fun onEvent(useCase: SplashViewModelEvent): ObservableSource<out SplashUiModel> {
        return when (useCase) {
            is SplashViewModelEvent.CheckLoginStatus -> interactor.isLoggedIn().map { SplashUiModel.LoginResult(it) }.toObservable()
        }
    }

    override fun onNext(useCase: SplashUiModel) {
        when (useCase) {
            is SplashUiModel.LoginResult -> {
                if (useCase.loggedIn) {
                    viewEventObservable.value = SplashViewEvent.GoToMain
                } else {
                    viewEventObservable.value = SplashViewEvent.GoToLogin
                }
            }
        }
    }
}