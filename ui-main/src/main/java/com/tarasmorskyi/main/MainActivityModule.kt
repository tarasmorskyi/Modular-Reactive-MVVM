package com.tarasmorskyi.main

import androidx.lifecycle.ViewModel
import com.tarasmorskyi.gallery.GalleryFragment
import com.tarasmorskyi.gallery.GalleryFragmentModule
import com.tarasmorskyi.gallery.api.GalleryUiEvents
import com.tarasmorskyi.main.api.GalleryUiEventsImpl
import com.tarasmorskyi.main.api.SettingsUiEventsImpl
import com.tarasmorskyi.main.settings.SettingsFragment
import com.tarasmorskyi.main.settings.SettingsFragmentModule
import com.tarasmorskyi.main.settings.api.SettingsUiEvents
import com.tarasmorskyi.uicore.FragmentScope
import com.tarasmorskyi.uicore.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap


@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [GalleryFragmentModule::class])
    abstract fun galleryFragment(): GalleryFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [SettingsFragmentModule::class])
    abstract fun settingsFragment(): SettingsFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    internal abstract fun provideGalleryUiEvents(
        galleryUiEvents: GalleryUiEventsImpl
    ): GalleryUiEvents

    @Binds
    internal abstract fun provideSettingsUiEvents(
        settingsUiEvents: SettingsUiEventsImpl
    ): SettingsUiEvents
}