package com.tarasmorskyi.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.tarasmorskyi.uicore.BaseActivity

class LoginActivity : BaseActivity<LoginViewEvent, LoginViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(LoginViewModel::class.java)

        setContentView(R.layout.activity_login)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        TODO("start sending events from here")
    }

    override fun onEvent(it: LoginViewEvent) {
        TODO("manage events from VM here. Never do request back to VM from here.")
    }

    companion object {

        fun createIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }
}