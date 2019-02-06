package com.tarasmorskyi.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.tarasmorskyi.gallery.GalleryFragment
import com.tarasmorskyi.gallery.GalleryFragmentSubcomponent
import com.tarasmorskyi.gallery.api.GalleryUiEvents
import com.tarasmorskyi.main.api.GalleryUiEventsImpl
import com.tarasmorskyi.main.api.SettingsUiEventsImpl
import com.tarasmorskyi.main.settings.SettingsFragment
import com.tarasmorskyi.main.settings.SettingsFragmentSubcomponent
import com.tarasmorskyi.main.settings.api.SettingsUiEvents
import com.tarasmorskyi.uicore.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap


@Module(subcomponents = [GalleryFragmentSubcomponent::class, SettingsFragmentSubcomponent::class])
abstract class MainActivityModule {

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

    @Binds
    @IntoMap
    @FragmentKey(GalleryFragment::class)
    internal abstract fun bindGalleryFragmentAndroidInjectorFactory(
        builder: GalleryFragmentSubcomponent.Builder
    ): AndroidInjector.Factory<out Fragment>

    @Binds
    @IntoMap
    @FragmentKey(SettingsFragment::class)
    internal abstract fun bindSettingsFragmentAndroidInjectorFactory(
        builder: SettingsFragmentSubcomponent.Builder
    ): AndroidInjector.Factory<out Fragment>
}