package com.tarasmorskyi.main.settings

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.tarasmorskyi.dataModel.SearchSettings
import com.tarasmorskyi.main.R
import com.tarasmorskyi.main.settings.api.SettingsUiEvents
import com.tarasmorskyi.uicore.BaseFragment
import com.tarasmorskyi.uicore.customViews.ToggleButtonGroupTableLayout
import kotlinx.android.synthetic.main.fragment_settings.*
import javax.inject.Inject

class SettingsFragment : BaseFragment<SettingsViewEvent, SettingsViewModel>(),
    ToggleButtonGroupTableLayout.RadioButtonChecked {

    @Inject
    lateinit var settingsUiEvents: SettingsUiEvents

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return View.inflate(activity as Context, R.layout.fragment_settings, null)
    }

    override fun setupViewModel() {
        viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(SettingsViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.event(SettingsViewModelEvent.GetSettings)
    }

    private fun setupSettings(searchSettings: SearchSettings) {
        when (searchSettings.section) {
            SearchSettings.HOT -> rgSection.onClick(hot)
            SearchSettings.TOP -> rgSection.onClick(top)
            SearchSettings.USER -> rgSection.onClick(user)
        }
        when (searchSettings.sort) {
            SearchSettings.VIRAL -> rgSort.onClick(viral)
            SearchSettings.TOP -> rgSort.onClick(topSort)
            SearchSettings.TIME -> rgSort.onClick(time)
        }
        when (searchSettings.window) {
            SearchSettings.DAY -> rgWindow.onClick(day)
            SearchSettings.WEEK -> rgWindow.onClick(week)
            SearchSettings.MONTH -> rgWindow.onClick(month)
            SearchSettings.YEAR -> rgWindow.onClick(year)
            SearchSettings.ALL -> rgWindow.onClick(all)
        }
        rgSection.onRadioButtonChecked(this)
        rgSort.onRadioButtonChecked(this)
        rgWindow.onRadioButtonChecked(this)

        showViral.isChecked = searchSettings.showViral
        mature.isChecked = searchSettings.mature
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        showViral.setOnCheckedChangeListener { _, isViral ->
            run {
                viewModel.event(SettingsViewModelEvent.SetSettingsShowViral(isViral))
            }
        }
        mature.setOnCheckedChangeListener { _, mature ->
            run {
                viewModel.event(SettingsViewModelEvent.SetSettingsMature(mature))
            }
        }
        logout.setOnClickListener { viewModel.event(SettingsViewModelEvent.Logout) }
    }

    override fun onRadioButtonChecked(view: View) {
        viewModel.event(SettingsViewModelEvent.SetSettingsFilter(view.id))
    }

    override fun onEvent(useCase: SettingsViewEvent) {
        when (useCase) {
            is SettingsViewEvent.GoToSplash -> activity?.let { settingsUiEvents.goToSplash(it) }

            is SettingsViewEvent.SetupSearchSettings -> setupSettings(useCase.searchSettings)

            is SettingsViewEvent.NotifyGalleryForUpdate -> settingsUiEvents.updateNotifier.accept(true)
        }
    }

    companion object {
        fun newInstance(): SettingsFragment {
            return SettingsFragment()
        }
    }
}