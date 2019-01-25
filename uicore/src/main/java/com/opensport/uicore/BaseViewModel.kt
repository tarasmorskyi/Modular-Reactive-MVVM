package com.opensport.uicore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject


abstract class BaseViewModel<UIM: BaseUiModel, VME: BaseViewModelEvent, VE: BaseViewEvent> : ViewModel(),
    Observer<UIM> {
    private val disposables = CompositeDisposable()

    protected val events: PublishSubject<VME> = PublishSubject.create<VME>()

    var errorObservable: MutableLiveData<Throwable> = MutableLiveData()

    var viewEventObservable: MutableLiveData<VE> = MutableLiveData()

    override fun onCleared() {
        disposables.clear()
    }

    init {
        events.flatMap { onEvent(it) }.observeOn(AndroidSchedulers.mainThread()).subscribe(this)
    }

    fun event(event: VME) {
        events.onNext(event)
    }

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
        disposables.add(d)
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        disposables.clear()
        events.flatMap { onEvent(it) }.observeOn(AndroidSchedulers.mainThread()).subscribe(this)
        errorObservable.value = e
    }

    protected abstract fun onEvent(useCase: VME): ObservableSource<UIM>
}