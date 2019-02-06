package com.tarasmorskyi.login

import com.tarasmorskyi.login.interactors.LoginInteractor
import com.tarasmorskyi.uicore.BaseViewModel
import io.reactivex.Observable
import io.reactivex.ObservableSource
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val interactor: LoginInteractor
) : BaseViewModel<LoginUiModel, LoginViewModelEvent, LoginViewEvent>() {

    override fun onEvent(useCase: LoginViewModelEvent): ObservableSource<out LoginUiModel> = when (useCase) {
        is LoginViewModelEvent.Login -> interactor.login(useCase.userAuthenticationData).andThen(
            Observable.just(
                LoginUiModel.GoToSplash
            )
        )
    }

    override fun onNext(useCase: LoginUiModel) = when (useCase) {
        is LoginUiModel.GoToSplash -> viewEventObservable.postValue(LoginViewEvent.GoToSplash)
    }
}