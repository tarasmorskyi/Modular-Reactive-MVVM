package com.tarasmorskyi.uicore

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.tarasmorskyi.myapplication.utils.errors.ResponseError
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


abstract class BaseActivity<VE : BaseViewEvent, VM : BaseViewModel<out BaseUiModel, out BaseViewModelEvent, VE>>
    : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModeFactory: DaggerViewModelFactory
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        if (::viewModel.isInitialized) {
            viewModel.errorObservable.observe(this, Observer {
                if (it != null) {
                    when (it) {
                        is ResponseError -> {
                            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                    viewModel.errorObservable.postValue(null)
                }
            })

            viewModel.viewEventObservable.observe(this, Observer {
                if (it != null) {
                    onEvent(it)
                    viewModel.viewEventObservable.postValue(null)
                }
            })
        }
    }

    abstract fun onEvent(useCase: VE)
}