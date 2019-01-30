package com.tarasmorskyi.myapplication.di

import com.tarasmorskyi.splash.splash.interactors.SplashInteractor
import com.tarasmorskyi.splash.splash.interactors.SplashInteractorImpl
import dagger.Binds
import dagger.Module


@Module
abstract class InteractorsModule {

    @Binds
    internal abstract fun provideSplashInteractor(
        splashInteractor: SplashInteractorImpl
    ): SplashInteractor
}