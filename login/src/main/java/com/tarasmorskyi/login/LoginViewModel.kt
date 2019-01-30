package com.tarasmorskyi.login

import com.tarasmorskyi.login.interactors.LoginInteractor
import com.tarasmorskyi.uicore.BaseViewModel
import io.reactivex.ObservableSource
import javax.inject.Inject

class LoginViewModel @Inject
constructor(private val interactor: LoginInteractor) :
    BaseViewModel<LoginUiModel, LoginViewModelEvent, LoginViewEvent>() {

    override fun onEvent(it: LoginViewModelEvent): ObservableSource<LoginUiModel> {
        TODO("call interactor methods from here without managing results")
    }

    override fun onNext(it: LoginUiModel) {
        TODO("manage events from RX here. Also post data to LiveData and View from here")
    }
}