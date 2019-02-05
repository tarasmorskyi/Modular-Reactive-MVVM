package com.opensport.previewgallery

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.opensport.previewgallery.api.GalleryUiEventsImpl
import com.tarasmorskyi.gallery.GalleryFragment
import com.tarasmorskyi.gallery.GalleryFragmentSubcomponent
import com.tarasmorskyi.gallery.api.GalleryUiEvents
import com.tarasmorskyi.uicore.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap


@Module(subcomponents = [GalleryFragmentSubcomponent::class])
abstract class PreviewGalleryActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(PreviewGalleryViewModel::class)
    abstract fun bindPreviewGalleryViewModel(viewModel: PreviewGalleryViewModel): ViewModel



    @Binds
    internal abstract fun provideGalleryUiEvents(
        galleryUiEvents: GalleryUiEventsImpl
    ): GalleryUiEvents

    @Binds
    @IntoMap
    @FragmentKey(GalleryFragment::class)
    internal abstract fun bindAndroidInjectorFactory(
        builder: GalleryFragmentSubcomponent.Builder
    ): AndroidInjector.Factory<out Fragment>
}