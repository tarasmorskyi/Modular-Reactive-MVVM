package com.opensport.localstorage

import com.opensport.data_model.SearchSettings
import com.opensport.data_model.UserAuthenticationData
import io.reactivex.Completable
import io.reactivex.Maybe

interface LocalRepository {

    val userAuthenticationData: Maybe<UserAuthenticationData>

    fun setUserAuthenticationData(userAuthenticationData: UserAuthenticationData): Completable

    val searchSettings: Maybe<SearchSettings>

    fun setSearchSettings(searchSettings: SearchSettings): Completable
}