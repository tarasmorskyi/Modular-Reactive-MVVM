package com.tarasmorskyi.mygallery

import androidx.lifecycle.ViewModel
import com.tarasmorskyi.uicore.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class MyGalleryFragmentModule {
    @Binds
    @IntoMap
    @ViewModelKey(MyGalleryViewModel::class)
    abstract fun bindMyGalleryViewModel(viewModel: MyGalleryViewModel): ViewModel
}