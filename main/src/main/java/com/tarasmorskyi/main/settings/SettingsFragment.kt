package com.tarasmorskyi.main.settings

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.tarasmorskyi.main.R
import com.tarasmorskyi.uicore.BaseFragment

class SettingsFragment: BaseFragment<SettingsViewEvent, SettingsViewModel>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = View.inflate(activity as Context, R.layout.fragment_settings, null)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(SettingsViewModel::class.java)
    }

    override fun onEvent(it: SettingsViewEvent) {
        TODO("manage events from VM here. Never do request back to VM from here.")
    }

    companion object {
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }
}