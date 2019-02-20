package com.tarasmorskyi.main.settings.api

import com.tarasmorskyi.dataModel.SearchSettings
import io.reactivex.Completable
import io.reactivex.Maybe

interface SettingsRepoEvents {

    fun settings(): Maybe<SearchSettings>

    fun setSettings(searchSettings: SearchSettings): Completable

    fun logout(): Completable
}