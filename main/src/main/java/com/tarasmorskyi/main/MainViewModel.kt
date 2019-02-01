package com.tarasmorskyi.main

import androidx.lifecycle.MutableLiveData
import com.tarasmorskyi.main.interactors.MainInteractor
import com.tarasmorskyi.uicore.BaseViewModel
import io.reactivex.ObservableSource
import javax.inject.Inject

class MainViewModel @Inject
constructor(private val interactor: MainInteractor) :
    BaseViewModel<MainUiModel, MainViewModelEvent, MainViewEvent>() {

    var fragmentPositionObservable = MutableLiveData<Int>()

    override fun onEvent(useCase: MainViewModelEvent): ObservableSource<MainUiModel> {
        TODO("call interactor methods from here without managing results")
    }

    override fun onNext(useCase: MainUiModel) {
        TODO("manage events from RX here. Also post data to LiveData and View from here")
    }
}