package com.tarasmorskyi.myapplication.moduleAPIs.repoEvents

import com.tarasmorskyi.data_model.SearchSettings
import com.tarasmorskyi.data_model.UserAuthenticationData
import com.tarasmorskyi.localstorage.LocalRepository
import com.tarasmorskyi.main.settings.api.SettingsRepoEvents
import io.reactivex.Completable
import io.reactivex.Maybe
import javax.inject.Inject

class SettingsRepoEventsImpl @Inject constructor(private val local: LocalRepository) : SettingsRepoEvents {

    override val settings: Maybe<SearchSettings> = local.searchSettings

    override fun setSettings(searchSettings: SearchSettings): Completable = local.setSearchSettings(searchSettings)

    override fun logout(): Completable = local.setUserAuthenticationData(
        UserAuthenticationData()
    )

}