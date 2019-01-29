package com.opensport.myapplication.di

import com.opensport.localstorage.Storage
import com.opensport.myapplication.App
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