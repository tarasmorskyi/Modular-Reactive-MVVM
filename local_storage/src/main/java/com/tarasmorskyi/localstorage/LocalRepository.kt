package com.tarasmorskyi.localstorage

import com.tarasmorskyi.data_model.SearchSettings
import com.tarasmorskyi.data_model.UserAuthenticationData
import io.reactivex.Completable
import io.reactivex.Maybe

interface LocalRepository {

    val userAuthenticationData: Maybe<UserAuthenticationData>

    fun setUserAuthenticationData(userAuthenticationData: UserAuthenticationData): Completable

    val searchSettings: Maybe<SearchSettings>

    fun setSearchSettings(searchSettings: SearchSettings): Completable
}