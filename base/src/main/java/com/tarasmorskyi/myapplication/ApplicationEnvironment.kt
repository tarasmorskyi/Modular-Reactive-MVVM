package com.tarasmorskyi.myapplication

import android.content.Context
import android.util.Log
import com.facebook.stetho.Stetho
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import timber.log.Timber


class ApplicationEnvironment(var app: App) {


    internal fun init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(app)
        } else {
            Timber.plant(CrashReportingTree())
        }
        val builder = Picasso.Builder(app as Context)
        builder.downloader(OkHttp3Downloader(app as Context, Long.MAX_VALUE))
        val built = builder.build()
        built.setIndicatorsEnabled(true)
        built.isLoggingEnabled = true
        Picasso.setSingletonInstance(built)
    }

    private class CrashReportingTree internal constructor() : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }
        }
    }
}
