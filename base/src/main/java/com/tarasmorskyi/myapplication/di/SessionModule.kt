package com.tarasmorskyi.myapplication.di

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
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

        @Provides
        @JvmStatic
        fun provideLayoutInflater(app: App): LayoutInflater {
            return app.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        @Provides
        @JvmStatic
        fun provideResources(app: App): Resources {
            return app.resources
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