package com.tarasmorskyi.myapplication.di

import com.tarasmorskyi.main.settings.SettingsFragment
import com.tarasmorskyi.main.settings.SettingsFragmentModule
import com.tarasmorskyi.mygallery.MyGalleryFragment
import com.tarasmorskyi.mygallery.MyGalleryFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class FragmentsModule {

    @ContributesAndroidInjector(modules = arrayOf(SettingsFragmentModule::class))
    internal abstract fun settingsFragment(): SettingsFragment

    @ContributesAndroidInjector(modules = arrayOf(MyGalleryFragmentModule::class))
    internal abstract fun myGalleryFragment(): MyGalleryFragment

}