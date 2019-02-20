package com.tarasmorskyi.myapplication.di

import com.tarasmorskyi.myapplication.App
import com.tarasmorskyi.myapplication.moduleAPIs.ModulesAPIsModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@SuppressWarnings("StaticMethodOnlyUsedInOneClass", "squid:S1118", "squid:S1610")
@Module(subcomponents = [SessionModule.SessionComponent::class])
internal abstract class SessionModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun sessionComponentBuilder(builder: SessionComponent.Builder): SessionComponent {
            return builder.build()
        }
    }

    @Binds
    internal abstract fun injector(component: SessionComponent): AndroidInjector<App>

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
}