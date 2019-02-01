package com.opensport.mygallery

import io.reactivex.Observable
import io.reactivex.ObservableSource
import com.opensport.mygallery.interactors.MyGalleryInteractor
import com.tarasmorskyi.uicore.BaseViewModel
import javax.inject.Inject

class MyGalleryViewModel @Inject
constructor(private val interactor: MyGalleryInteractor) :
    BaseViewModel<MyGalleryUiModel, MyGalleryViewModelEvent, MyGalleryViewEvent>() {

    override fun onEvent(useCase: MyGalleryViewModelEvent): ObservableSource<MyGalleryUiModel> {
        TODO("call interactor methods from here without managing results")
    }

    override fun onNext(useCase: MyGalleryUiModel) {
        TODO("manage events from RX here. Also post data to LiveData and View from here")
    }
}