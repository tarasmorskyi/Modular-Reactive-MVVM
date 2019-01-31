package com.tarasmorskyi.login

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModelProviders
import com.tarasmorskyi.api.LoginUiEvents
import com.tarasmorskyi.data_model.UserAuthenticationData
import com.tarasmorskyi.uicore.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*
import javax.inject.Inject

class LoginActivity : BaseActivity<LoginViewEvent, LoginViewModel>() {

    @Inject
    lateinit var loginUiEvents: LoginUiEvents

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(LoginViewModel::class.java)

        setContentView(R.layout.activity_login)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        val webClient: WebViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                parseLoginDataIfLoggedIn(url)
            }
        }
        webView.setWebViewClient(webClient)
        webView.settings.userAgentString = "demoapp"
        webView.clearFormData()
        webView.settings.javaScriptEnabled = true

        webView.loadUrl("https://api.imgur.com/oauth2/authorize?client_id=9a9f8a8c12cb9ce&response_type=token&state=demoapp")

    }

    private fun parseLoginDataIfLoggedIn(url: String?) {
        if (url!!.contains("imgur.com") && url!!.contains("access_token")) {
            val params = url!!.substring(url!!.indexOf("#") + 1).split("&")
            val map = HashMap<String, String>()
            for (param in params) {
                val name = param.split("=".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()[0]
                val value = param.split("=".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()[1]
                map[name] = value
            }
            val userAuthenticationData = UserAuthenticationData(map.get("access_token")!!,
                map.get("expires_in")?.toLong()!!, map.get("token_type")!!, map.get("refresh_token")!!,
                map.get("account_username")!!, map.get("account_id")?.toLong()!!)
            viewModel.event(LoginViewModelEvent.Login(userAuthenticationData))
        }
    }

    override fun onEvent(useCase: LoginViewEvent) {
        when (useCase) {
            is LoginViewEvent.GoToSplash -> loginUiEvents.startSplashScreen(this)
        }
    }

    companion object {

        fun createIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }
}