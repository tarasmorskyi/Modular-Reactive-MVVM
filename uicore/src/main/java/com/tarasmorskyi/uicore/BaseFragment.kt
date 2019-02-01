package com.tarasmorskyi.uicore

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.tarasmorskyi.myapplication.utils.errors.ResponseError
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


abstract class BaseFragment<VE: BaseViewEvent, VM : BaseViewModel<out BaseUiModel, out BaseViewModelEvent, VE>> : Fragment() {

    @Inject
    lateinit var viewModeFactory: DaggerViewModelFactory
    protected lateinit var viewModel: VM

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        setupViewModel()
        super.onActivityCreated(savedInstanceState)
        if (::viewModel.isInitialized) {
            viewModel.errorObservable.observe(this, Observer {
                when (it) {
                    is ResponseError -> {
                        Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
                    }
                }
                viewModel.errorObservable.postValue(null)
            })

            viewModel.viewEventObservable.observe(this, Observer {
                onEvent(it)
            })
        }
    }

    abstract fun setupViewModel()

    abstract fun onEvent(useCase: VE)

}