package com.tarasmorskyi.myapplication.moduleAPIs

import com.tarasmorskyi.myapplication.moduleAPIs.repoEvents.SplashRepoEventsImpl
import com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs.SplashUiEventsImpl
import com.tarasmorskyi.splash.api.SplashRepoEvents
import com.tarasmorskyi.splash.api.SplashUiEvents
import dagger.Binds
import dagger.Module

@Module
abstract class ModulesAPIsModule {
    @Binds
    internal abstract fun provideSplashUiEvents(
        splashUiEvents: SplashUiEventsImpl
    ): SplashUiEvents

    @Binds
    internal abstract fun provideSplashRepoEvents(
        splashRepoEvents: SplashRepoEventsImpl
    ): SplashRepoEvents
}