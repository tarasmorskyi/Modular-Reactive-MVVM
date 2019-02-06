package com.tarasmorskyi.myapplication.di

import com.opensport.previewgallery.PreviewGalleryActivity
import com.opensport.previewgallery.PreviewGalleryActivityModule
import com.tarasmorskyi.login.LoginActivity
import com.tarasmorskyi.login.LoginActivityModule
import com.tarasmorskyi.main.MainActivity
import com.tarasmorskyi.main.MainActivityModule
import com.tarasmorskyi.splash.SplashActivity
import com.tarasmorskyi.splash.SplashActivityModule
import com.tarasmorskyi.uicore.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun splashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    internal abstract fun loginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun mainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [PreviewGalleryActivityModule::class])
    internal abstract fun previewGalleryActivity(): PreviewGalleryActivity

}