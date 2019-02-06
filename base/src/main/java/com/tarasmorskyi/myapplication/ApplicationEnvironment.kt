package com.tarasmorskyi.myapplication

import android.util.Log
import com.facebook.stetho.Stetho
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable
import timber.log.Timber


class ApplicationEnvironment(var app: App) : CompletableObserver {


    internal fun init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(app)
        } else {
            Timber.plant(CrashReportingTree())
        }
    }

    override fun onSubscribe(d: Disposable) {
        //ignored
    }

    override fun onComplete() {
        Timber.d("delayed loading finished")
    }

    override fun onError(e: Throwable) {
        Timber.e(e, "onError() called")
    }

    private class CrashReportingTree internal constructor() : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }
        }
    }

    companion object {
    }
}
