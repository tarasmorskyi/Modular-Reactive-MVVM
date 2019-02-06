package com.tarasmorskyi.main.settings.interactors

import com.tarasmorskyi.dataModel.SearchSettings
import io.reactivex.Completable
import io.reactivex.Maybe

interface SettingsInteractor {

    val settings: Maybe<SearchSettings>

    fun setSettingsMature(mature: Boolean): Completable

    fun setSettingsShowViral(isViral: Boolean): Completable

    fun setSettingsFilter(filterId: Int): Completable

    fun logout(): Completable
}