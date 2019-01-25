package com.opensport.myapplication.di

import com.opensport.splash.splash.interactors.SplashInteractor
import com.opensport.splash.splash.interactors.SplashInteractorImpl
import dagger.Binds
import dagger.Module


@Module
abstract class InteractorsModule {

    @Binds
    internal abstract fun provideSplashInteractor(
        splashInteractor: SplashInteractorImpl
    ): SplashInteractor
}