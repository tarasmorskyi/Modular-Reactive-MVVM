package com.tarasmorskyi.myapplication.di

import com.tarasmorskyi.localstorage.Storage
import com.tarasmorskyi.myapplication.App
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Provides
    @Singleton
    internal fun provideStorage(application: App, moshi: Moshi): Storage {
        return Storage.getDefault(application, moshi)
    }
}