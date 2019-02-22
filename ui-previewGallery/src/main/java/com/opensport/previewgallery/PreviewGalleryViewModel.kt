package com.opensport.previewgallery

import com.opensport.previewgallery.interactors.PreviewGalleryInteractor
import com.tarasmorskyi.uicore.BaseViewModel
import io.reactivex.Observable
import javax.inject.Inject

class PreviewGalleryViewModel @Inject constructor(
    private val interactor: PreviewGalleryInteractor
) : BaseViewModel<PreviewGalleryUiModel, PreviewGalleryViewModelEvent, PreviewGalleryViewEvent>() {

    override fun onEvent(useCase: PreviewGalleryViewModelEvent): Observable<out PreviewGalleryUiModel> {
        TODO("call interactor methods from here without managing results")
    }

    override fun onNext(useCase: PreviewGalleryUiModel) {
        TODO("manage events from RX here. Also post data to LiveData and View from here")
    }
}