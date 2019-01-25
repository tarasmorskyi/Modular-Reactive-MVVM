package com.opensport.splash.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.opensport.splash.splash.interactors.SplashInteractor
import javax.inject.Inject

class SplashViewModelFactory
@Inject constructor(private val interactor: SplashInteractor) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            return SplashViewModel(interactor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}