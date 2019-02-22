package com.tarasmorskyi.uicore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject


abstract class BaseViewModel<UIM : BaseUiModel, VME : BaseViewModelEvent, VE : BaseViewEvent>
    : ViewModel(), Observer<UIM> {

    private val disposables = CompositeDisposable()

    private val events: PublishSubject<VME> = PublishSubject.create<VME>()

    var errorObservable: MutableLiveData<Throwable> = MutableLiveData()

    var viewEventObservable: MutableLiveData<VE> = MutableLiveData()

    init {
        events.flatMap { onEvent(it) }.observeOn(AndroidSchedulers.mainThread())
            .subscribe(this)
    }

    override fun onSubscribe(d: Disposable) {
        disposables.add(d)
    }

    override fun onCleared() {
        disposables.dispose()
    }

    override fun onComplete() {
    }

    fun event(event: VME) {
        events.onNext(event)
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        disposables.clear()
        events.flatMap { onEvent(it) }.observeOn(AndroidSchedulers.mainThread()).subscribe(this)
        errorObservable.value = e
    }

    abstract fun onEvent(useCase: VME): Observable<out UIM>
}