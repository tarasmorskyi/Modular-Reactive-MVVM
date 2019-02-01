package com.tarasmorskyi.myapplication.moduleAPIs

import com.tarasmorskyi.api.LoginRepoEvents
import com.tarasmorskyi.api.LoginUiEvents
import com.tarasmorskyi.main.settings.api.SettingsRepoEvents
import com.tarasmorskyi.main.settings.api.SettingsUiEvents
import com.tarasmorskyi.myapplication.moduleAPIs.repoEvents.LoginRepoEventsImpl
import com.tarasmorskyi.myapplication.moduleAPIs.repoEvents.SettingsRepoEventsImpl
import com.tarasmorskyi.myapplication.moduleAPIs.repoEvents.SplashRepoEventsImpl
import com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs.LoginUiEventsImpl
import com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs.SettingsUiEventsImpl
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
    @Binds
    internal abstract fun provideLoginUiEvents(
        loginUiEvents: LoginUiEventsImpl
    ): LoginUiEvents

    @Binds
    internal abstract fun provideLoginRepoEvents(
        loginRepoEvents: LoginRepoEventsImpl
    ): LoginRepoEvents

    @Binds
    internal abstract fun provideSettingsRepoEvents(
        settingsRepoEvents: SettingsRepoEventsImpl
    ): SettingsRepoEvents

    @Binds
    internal abstract fun provideSettingsUiEvents(
        settingsUiEvents: SettingsUiEventsImpl
    ): SettingsUiEvents
}