package com.tarasmorskyi.myapplication.di

import com.opensport.gallery.interactors.GalleryInteractor
import com.opensport.gallery.interactors.GalleryInteractorImpl
import com.opensport.mygallery.interactors.MyGalleryInteractor
import com.opensport.mygallery.interactors.MyGalleryInteractorImpl
import com.tarasmorskyi.login.interactors.LoginInteractor
import com.tarasmorskyi.login.interactors.LoginInteractorImpl
import com.tarasmorskyi.main.interactors.MainInteractor
import com.tarasmorskyi.main.interactors.MainInteractorImpl
import com.tarasmorskyi.main.settings.interactors.SettingsInteractor
import com.tarasmorskyi.main.settings.interactors.SettingsInteractorImpl
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

    @Binds
    internal abstract fun provideLoginInteractor(
        loginInteractor: LoginInteractorImpl
    ): LoginInteractor

    @Binds
    internal abstract fun provideMainInteractor(
        mainInteractor: MainInteractorImpl
    ): MainInteractor

    @Binds
    internal abstract fun provideSettingsInteractor(
        settingsInteractor: SettingsInteractorImpl
    ): SettingsInteractor

    @Binds
    internal abstract fun provideGalleryInteractor(
        galleryInteractor: GalleryInteractorImpl
    ): GalleryInteractor

    @Binds
    internal abstract fun provideMyGalleryInteractor(
        myGalleryInteractor: MyGalleryInteractorImpl
    ): MyGalleryInteractor
}