package com.tarasmorskyi.myapplication.di

import com.tarasmorskyi.myapplication.App
import com.tarasmorskyi.myapplication.moduleAPIs.ModulesAPIsModule
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@SessionScope
@Subcomponent(
    modules = [
        InteractorsModule::class,
        ModulesAPIsModule::class,
        ActivitiesModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelFactoryModule::class]
)
interface SessionComponent : AndroidInjector<App> {
    @Subcomponent.Builder
    abstract class Builder {
        abstract fun build(): SessionComponent
    }
}