package com.opensport.gallery

import androidx.lifecycle.ViewModel
import com.tarasmorskyi.uicore.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class GalleryFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(GalleryViewModel::class)
    abstract fun bindGalleryViewModel(viewModel: GalleryViewModel): ViewModel
}