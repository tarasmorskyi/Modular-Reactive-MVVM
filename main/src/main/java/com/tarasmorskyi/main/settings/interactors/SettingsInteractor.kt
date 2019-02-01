package com.tarasmorskyi.main.settings.interactors

import com.tarasmorskyi.data_model.SearchSettings
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable

interface SettingsInteractor {
    val settings: Maybe<SearchSettings>
    fun setSettingsMature(mature: Boolean): Completable
    fun setSettingsShowViral(isViral: Boolean): Completable
    fun setSettingsFilter(filterId: Int): Completable
    fun logout(): Completable
}