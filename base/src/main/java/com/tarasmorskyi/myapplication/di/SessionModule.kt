package com.tarasmorskyi.myapplication.di

import com.tarasmorskyi.myapplication.App
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector

@SuppressWarnings("StaticMethodOnlyUsedInOneClass", "squid:S1118", "squid:S1610")
@Module(includes = [SessionProviderModule::class])
internal abstract class SessionModule {
    @Binds
    internal abstract fun injector(component: SessionComponent): AndroidInjector<App>


}