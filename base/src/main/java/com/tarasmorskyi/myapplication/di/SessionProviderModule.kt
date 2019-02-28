package com.tarasmorskyi.myapplication.di

import dagger.Module
import dagger.Provides

@Module(subcomponents = [SessionComponent::class])
class SessionProviderModule {

    @Provides
    fun sessionComponentBuilder(builder: SessionComponent.Builder): SessionComponent {
        return builder.build()
    }
}