package com.opensport.myapplication.di

import com.opensport.myapplication.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
//    DomainToolsModule::class, RepositoryModule::class,
    AndroidSupportInjectionModule::class, SessionModule::class))
interface AppComponent : AndroidInjector<App> {

    fun androidInjector(): AndroidInjector<App>

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        abstract override fun build(): AppComponent
    }
}