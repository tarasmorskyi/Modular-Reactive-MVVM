package com.tarasmorskyi.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.tarasmorskyi.uicore.BaseActivity

class MainActivity : BaseActivity<MainViewEvent, MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(MainViewModel::class.java)

        setContentView(R.layout.activity_main)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        TODO("start sending events from here")
    }

    override fun onEvent(useCase: MainViewEvent) {
        TODO("manage events from VM here. Never do request back to VM from here.")
    }

    companion object {

        fun createIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }
}