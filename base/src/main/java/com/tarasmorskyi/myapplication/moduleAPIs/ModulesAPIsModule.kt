package com.tarasmorskyi.myapplication.moduleAPIs

import com.tarasmorskyi.gallery.api.GalleryRepoEvents
import com.tarasmorskyi.login.api.LoginRepoEvents
import com.tarasmorskyi.login.api.LoginUiEvents
import com.tarasmorskyi.main.api.MainUiEvents
import com.tarasmorskyi.main.settings.api.SettingsRepoEvents
import com.tarasmorskyi.myapplication.moduleAPIs.repoEvents.GalleryRepoEventsImpl
import com.tarasmorskyi.myapplication.moduleAPIs.repoEvents.LoginRepoEventsImpl
import com.tarasmorskyi.myapplication.moduleAPIs.repoEvents.SettingsRepoEventsImpl
import com.tarasmorskyi.myapplication.moduleAPIs.repoEvents.SplashRepoEventsImpl
import com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs.LoginUiEventsImpl
import com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs.MainUiEventsImpl
import com.tarasmorskyi.myapplication.moduleAPIs.uiAPIs.SplashUiEventsImpl
import com.tarasmorskyi.splash.api.SplashRepoEvents
import com.tarasmorskyi.splash.api.SplashUiEvents
import com.tarasmorskyi.uicore.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class ModulesAPIsModule {

    @ActivityScope
    @Binds
    internal abstract fun provideSplashUiEvents(
        splashUiEvents: SplashUiEventsImpl
    ): SplashUiEvents

    @ActivityScope
    @Binds
    internal abstract fun provideSplashRepoEvents(
        splashRepoEvents: SplashRepoEventsImpl
    ): SplashRepoEvents

    @ActivityScope
    @Binds
    internal abstract fun provideLoginUiEvents(
        loginUiEvents: LoginUiEventsImpl
    ): LoginUiEvents

    @ActivityScope
    @Binds
    internal abstract fun provideLoginRepoEvents(
        loginRepoEvents: LoginRepoEventsImpl
    ): LoginRepoEvents

    @ActivityScope
    @Binds
    internal abstract fun provideSettingsRepoEvents(
        settingsRepoEvents: SettingsRepoEventsImpl
    ): SettingsRepoEvents

    @ActivityScope
    @Binds
    internal abstract fun provideMainUiEvents(
        mainUiEvents: MainUiEventsImpl
    ): MainUiEvents

    @ActivityScope
    @Binds
    internal abstract fun provideGalleryRepoEvents(
        galleryRepoEvents: GalleryRepoEventsImpl
    ): GalleryRepoEvents
}