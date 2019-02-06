package com.tarasmorskyi.myapplication.di

import com.tarasmorskyi.localstorage.LocalRepositoryModule
import com.tarasmorskyi.myapplication.App
import com.tarasmorskyi.remote.RemoteRepositoryModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DomainToolsModule::class, LocalRepositoryModule::class, RemoteRepositoryModule::class,
        AndroidSupportInjectionModule::class, SessionModule::class]
)
interface AppComponent : AndroidInjector<App> {

    fun androidInjector(): AndroidInjector<App>

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        abstract override fun build(): AppComponent
    }
}