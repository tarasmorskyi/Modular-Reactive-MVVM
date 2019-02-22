package com.tarasmorskyi.main.settings

import com.tarasmorskyi.dataModel.SearchSettings
import com.tarasmorskyi.uicore.BaseViewEvent

sealed class SettingsViewEvent : BaseViewEvent {

    object GoToSplash : SettingsViewEvent()

    object NotifyGalleryForUpdate : SettingsViewEvent()

    data class SetupSearchSettings(val searchSettings: SearchSettings) : SettingsViewEvent()
}