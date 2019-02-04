package com.tarasmorskyi.gallery

import com.tarasmorskyi.uicore.FragmentScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(GalleryFragmentModule::class))
@FragmentScope
interface GalleryFragmentSubcomponent : AndroidInjector<GalleryFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<GalleryFragment>()
}