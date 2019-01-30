package com.tarasmorskyi.myapplication.di

import androidx.lifecycle.ViewModelProvider
import com.tarasmorskyi.uicore.DaggerViewModelFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}