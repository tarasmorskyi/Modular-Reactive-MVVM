package com.tarasmorskyi.main.settings

import com.tarasmorskyi.uicore.FragmentScope
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent(modules = [SettingsFragmentModule::class])
@FragmentScope
interface SettingsFragmentSubcomponent : AndroidInjector<SettingsFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SettingsFragment>()
}