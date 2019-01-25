package com.opensport.splash.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.opensport.splash.R
import com.opensport.splash.api.SplashUiEvents
import com.opensport.uicore.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity<SplashViewEvent, SplashViewModel>() {

    @Inject
    lateinit var splashUiEvents: SplashUiEvents

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(SplashViewModel::class.java)

        setContentView(R.layout.activity_splash)

        fab.setOnClickListener { view ->
            splashUiEvents.startLoginScreen(this)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
    }

    override fun onEvent(it: SplashViewEvent) {
        TODO("manage events from VM here. Never do request back to VM from here.")
    }

    companion object {

        fun createIntent(context: Context): Intent {
            val intent = Intent(context, SplashActivity::class.java)
            return intent
        }
    }
}