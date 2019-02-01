package com.tarasmorskyi.main.settings

import com.tarasmorskyi.data_model.SearchSettings
import com.tarasmorskyi.uicore.BaseUiModel

sealed class SettingsUiModel : BaseUiModel {
    data class SetSettings(val searchSettings: SearchSettings) : SettingsUiModel()
    object LoggedOut : SettingsUiModel()
}