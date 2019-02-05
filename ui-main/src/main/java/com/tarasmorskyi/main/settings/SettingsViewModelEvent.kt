package com.tarasmorskyi.main.settings

import com.tarasmorskyi.uicore.BaseViewModelEvent

sealed class SettingsViewModelEvent : BaseViewModelEvent {
    object GetSettings : SettingsViewModelEvent()
    data class SetSettingsMature(val mature: Boolean) : SettingsViewModelEvent()
    data class SetSettingsShowViral(val isViral: Boolean) : SettingsViewModelEvent()
    data class SetSettingsFilter(val filterId: Int) : SettingsViewModelEvent()
    object Logout : SettingsViewModelEvent()
}