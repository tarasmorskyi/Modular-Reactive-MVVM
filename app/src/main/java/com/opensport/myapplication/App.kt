package com.opensport.myapplication

import android.content.Context
import androidx.multidex.MultiDex
import com.jakewharton.threetenabp.AndroidThreeTen
import com.opensport.myapplication.di.AppComponent
import com.opensport.myapplication.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class App : DaggerApplication {

    lateinit var applicationEnvironment: ApplicationEnvironment

    companion object {
        private lateinit var application: App

        fun getInstance() : App {
            return application
        }
    }

    constructor(){
        application = this
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        applicationEnvironment = ApplicationEnvironment(application)
        applicationEnvironment.init()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        var builder : AppComponent.Builder = DaggerAppComponent.builder()
        builder.seedInstance(this)
        return builder.build().androidInjector()
    }
}