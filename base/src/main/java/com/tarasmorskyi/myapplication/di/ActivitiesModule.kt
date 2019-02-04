package com.tarasmorskyi.myapplication.di

import com.opensport.previewgallery.PreviewGalleryActivity
import com.opensport.previewgallery.PreviewGalleryActivityModule
import com.tarasmorskyi.login.LoginActivity
import com.tarasmorskyi.login.LoginActivityModule
import com.tarasmorskyi.main.MainActivity
import com.tarasmorskyi.main.MainActivityModule
import com.tarasmorskyi.splash.splash.SplashActivity
import com.tarasmorskyi.splash.splash.SplashActivityModule
import com.tarasmorskyi.uicore.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector





@Module
internal abstract class ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(SplashActivityModule::class))
    internal abstract fun splashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
    internal abstract fun loginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    internal abstract fun mainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(PreviewGalleryActivityModule::class))
    internal abstract fun previewGalleryActivity(): PreviewGalleryActivity

}