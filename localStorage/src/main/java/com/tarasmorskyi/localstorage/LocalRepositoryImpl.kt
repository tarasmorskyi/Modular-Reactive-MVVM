package com.tarasmorskyi.localstorage

import com.tarasmorskyi.dataModel.SearchSettings
import com.tarasmorskyi.dataModel.UserAuthenticationData
import io.reactivex.Completable
import io.reactivex.Maybe
import javax.inject.Inject

class LocalRepositoryImpl @Inject internal constructor(
    private val storage: Storage
) : LocalRepository {

    override val userAuthenticationData: Maybe<UserAuthenticationData>
        get() = Maybe.fromCallable {
            storage[USER, UserAuthenticationData::class.java, UserAuthenticationData()]
        }

    override fun setUserAuthenticationData(userAuthenticationData: UserAuthenticationData): Completable {
        return Completable.fromAction { storage[USER, userAuthenticationData] = UserAuthenticationData::class.java }
    }

    override val searchSettings: Maybe<SearchSettings>
        get() = Maybe.fromCallable {
            storage[SEARCH_SETTINGS, SearchSettings::class.java, SearchSettings()]
        }

    override fun setSearchSettings(searchSettings: SearchSettings): Completable {
        return Completable.fromAction { storage[SEARCH_SETTINGS, searchSettings] = SearchSettings::class.java }
    }

    companion object {
        const val USER = "user"
        private const val SEARCH_SETTINGS = "search_settings"
    }
}