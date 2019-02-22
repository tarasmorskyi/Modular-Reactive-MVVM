package com.opensport.previewgallery

import androidx.lifecycle.ViewModel
import com.opensport.previewgallery.api.GalleryUiEventsImpl
import com.tarasmorskyi.gallery.GalleryFragment
import com.tarasmorskyi.gallery.GalleryFragmentModule
import com.tarasmorskyi.gallery.api.GalleryUiEvents
import com.tarasmorskyi.uicore.FragmentScope
import com.tarasmorskyi.uicore.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap


@Module
abstract class PreviewGalleryActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [GalleryFragmentModule::class])
    abstract fun galleryFragment(): GalleryFragment

    @Binds
    @IntoMap
    @ViewModelKey(PreviewGalleryViewModel::class)
    abstract fun bindPreviewGalleryViewModel(viewModel: PreviewGalleryViewModel): ViewModel

    @Binds
    internal abstract fun provideGalleryUiEvents(
        galleryUiEvents: GalleryUiEventsImpl
    ): GalleryUiEvents
}