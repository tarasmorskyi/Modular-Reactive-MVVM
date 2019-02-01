package com.tarasmorskyi.myapplication.di

import com.tarasmorskyi.main.settings.SettingsFragment
import com.tarasmorskyi.main.settings.SettingsFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
internal abstract class FragmentsModule {

    @ContributesAndroidInjector(modules = arrayOf(SettingsFragmentModule::class))
    internal abstract fun settingsFragment(): SettingsFragment

}