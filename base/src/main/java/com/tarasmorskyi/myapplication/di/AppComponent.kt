package com.tarasmorskyi.myapplication.di

import com.tarasmorskyi.localstorage.LocalRepositoryModule
import com.tarasmorskyi.myapplication.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    DomainToolsModule::class, LocalRepositoryModule::class,
    AndroidSupportInjectionModule::class, SessionModule::class))
interface AppComponent : AndroidInjector<App> {

    fun androidInjector(): AndroidInjector<App>

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        abstract override fun build(): AppComponent
    }
}