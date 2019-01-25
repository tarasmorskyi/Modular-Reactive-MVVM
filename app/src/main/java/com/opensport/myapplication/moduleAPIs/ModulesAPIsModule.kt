package com.opensport.myapplication.moduleAPIs

import com.opensport.myapplication.moduleAPIs.uiAPIs.SplashUiEventsImpl
import com.opensport.splash.api.SplashUiEvents
import dagger.Binds
import dagger.Module

@Module
abstract class ModulesAPIsModule{
    @Binds
    internal abstract fun provideSplashUiEvents(
        splashUiEvents: SplashUiEventsImpl): SplashUiEvents
}