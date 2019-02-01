package com.opensport.gallery

import io.reactivex.Observable
import io.reactivex.ObservableSource
import com.opensport.gallery.interactors.GalleryInteractor
import com.tarasmorskyi.uicore.BaseViewModel
import javax.inject.Inject

class GalleryViewModel @Inject
constructor(private val interactor: GalleryInteractor) :
    BaseViewModel<GalleryUiModel, GalleryViewModelEvent, GalleryViewEvent>() {

    override fun onEvent(useCase: GalleryViewModelEvent): ObservableSource<GalleryUiModel> {
        TODO("call interactor methods from here without managing results")
    }

    override fun onNext(useCase: GalleryUiModel) {
        TODO("manage events from RX here. Also post data to LiveData and View from here")
    }
}