package com.tarasmorskyi.main.settings

import com.tarasmorskyi.data_model.SearchSettings
import com.tarasmorskyi.uicore.BaseViewEvent

sealed class SettingsViewEvent : BaseViewEvent {
    object GoToSplash : SettingsViewEvent()
    class SetupSearchSettings(val searchSettings: SearchSettings) : SettingsViewEvent()
}