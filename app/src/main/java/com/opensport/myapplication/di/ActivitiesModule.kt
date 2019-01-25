package com.opensport.myapplication.di

import com.opensport.splash.splash.SplashActivity
import com.opensport.splash.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(SplashActivityModule::class))
    internal abstract fun splashActivity(): SplashActivity
//
//    @ActivityScope
//    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
//    internal abstract fun loginActivity(): LoginActivity
//
//    @ActivityScope
//    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
//    internal abstract fun mainActivity(): MainActivity

}