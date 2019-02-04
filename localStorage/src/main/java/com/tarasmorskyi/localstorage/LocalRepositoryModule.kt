package com.tarasmorskyi.localstorage

import dagger.Binds
import dagger.Module

@Module
abstract class LocalRepositoryModule {
    @Binds
    protected abstract fun localRepository(localRepository: LocalRepositoryImpl): LocalRepository
}