package com.tarasmorskyi.remote

import dagger.Binds
import dagger.Module


@Module
abstract class RemoteRepositoryModule {
    @Binds
    protected abstract fun remoteRepository(remoteRepository: RemoteRepositoryImpl): RemoteRepository
}