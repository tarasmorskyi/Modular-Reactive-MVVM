package com.tarasmorskyi.myapplication.di

import com.opensport.gallery.GalleryFragment
import com.opensport.gallery.GalleryFragmentModule
import com.tarasmorskyi.main.settings.SettingsFragment
import com.tarasmorskyi.main.settings.SettingsFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class FragmentsModule {

    @ContributesAndroidInjector(modules = arrayOf(SettingsFragmentModule::class))
    internal abstract fun settingsFragment(): SettingsFragment

    @ContributesAndroidInjector(modules = arrayOf(GalleryFragmentModule::class))
    internal abstract fun galleryFragment(): GalleryFragment

}