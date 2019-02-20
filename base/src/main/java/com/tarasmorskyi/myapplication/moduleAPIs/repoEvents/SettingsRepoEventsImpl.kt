package com.tarasmorskyi.myapplication.moduleAPIs.repoEvents

import com.tarasmorskyi.dataModel.SearchSettings
import com.tarasmorskyi.dataModel.UserAuthenticationData
import com.tarasmorskyi.localstorage.LocalRepository
import com.tarasmorskyi.main.settings.api.SettingsRepoEvents
import io.reactivex.Completable
import io.reactivex.Maybe
import javax.inject.Inject

class SettingsRepoEventsImpl @Inject constructor(
    private val local: LocalRepository
) : SettingsRepoEvents {

    override fun settings(): Maybe<SearchSettings> = local.searchSettings

    override fun setSettings(searchSettings: SearchSettings): Completable = local.setSearchSettings(searchSettings)

    override fun logout(): Completable = local.setUserAuthenticationData(
        UserAuthenticationData()
    )
}