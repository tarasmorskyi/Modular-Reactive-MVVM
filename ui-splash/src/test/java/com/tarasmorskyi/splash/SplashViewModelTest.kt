package com.tarasmorskyi.splash

import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.tarasmorskyi.splash.interactors.SplashInteractor
import com.tarasmorskyi.uicore.BaseViewModelTest
import io.reactivex.Maybe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


internal class SplashViewModelTest: BaseViewModelTest(){

    lateinit var splashInteractor: SplashInteractor
    lateinit var splashViewModel: SplashViewModel
    lateinit var viewEventObservable: MutableLiveData<SplashViewEvent>


    @BeforeEach
    fun setUp() {
        splashInteractor = mock { }
        splashViewModel = SplashViewModel(splashInteractor)
        viewEventObservable = mock { }
        splashViewModel.viewEventObservable = viewEventObservable
    }

    @Test
    fun onEvent() {
        whenever(splashInteractor.isLoggedIn()).thenReturn(Maybe.just(true))
        assert(splashViewModel.onEvent(SplashViewModelEvent.CheckLoginStatus).test().values()[0] == SplashUiModel.LoginResult(true))
        verify(splashInteractor).isLoggedIn()
    }

    @Test
    fun onNextLoggedIn() {
        splashViewModel.onNext(SplashUiModel.LoginResult(true))
        verify(viewEventObservable).value = SplashViewEvent.GoToMain
    }

    @Test
    fun onNextNotLoggedIn() {
        splashViewModel.onNext(SplashUiModel.LoginResult(false))
        verify(viewEventObservable).value = SplashViewEvent.GoToLogin
    }
}