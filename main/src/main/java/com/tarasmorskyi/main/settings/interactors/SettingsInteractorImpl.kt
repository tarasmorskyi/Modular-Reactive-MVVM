package com.tarasmorskyi.main.settings.interactors

import com.tarasmorskyi.data_model.SearchSettings
import com.tarasmorskyi.main.R
import com.tarasmorskyi.main.settings.api.SettingsRepoEvents
import io.reactivex.Completable
import io.reactivex.Maybe
import javax.inject.Inject

class SettingsInteractorImpl @Inject constructor(private val settingsRepoEvents: SettingsRepoEvents) :
    SettingsInteractor {

    override val settings: Maybe<SearchSettings> = settingsRepoEvents.settings

    override fun setSettingsMature(mature: Boolean): Completable {
        return settingsRepoEvents.settings.flatMapCompletable { searchSettings ->
            if (searchSettings.mature == mature)
                return@flatMapCompletable Completable.complete()

            searchSettings.mature = mature
            return@flatMapCompletable settingsRepoEvents.setSettings(searchSettings)
        }
    }

    override fun setSettingsShowViral(isViral: Boolean): Completable {
        return settingsRepoEvents.settings.flatMapCompletable { searchSettings ->
            if (searchSettings.showViral == isViral)
                return@flatMapCompletable Completable.complete()

            searchSettings.showViral = isViral
            return@flatMapCompletable settingsRepoEvents.setSettings(searchSettings)
        }
    }

    override fun setSettingsFilter(filterId: Int): Completable {
        return settingsRepoEvents.settings.flatMapCompletable { searchSettings ->
            var section: String = searchSettings.section
            var sort: String = searchSettings.sort
            var window: String = searchSettings.window
            when (filterId) {
                R.id.hot -> section = "hot"
                R.id.top -> section = "top"
                R.id.user -> section = "user"

                R.id.viral -> sort = "viral"
                R.id.topSort -> sort = "top"
                R.id.time -> sort = "time"

                R.id.day -> window = "day"
                R.id.week -> window = "week"
                R.id.month -> window = "month"
                R.id.year -> window = "year"
                R.id.all -> window = "all"
            }
            if (searchSettings.section == section &&
                searchSettings.sort == sort &&
                searchSettings.window == window
            ) {
                return@flatMapCompletable Completable.complete()
            }
            searchSettings.section = section
            searchSettings.sort = sort
            searchSettings.window = window
            return@flatMapCompletable settingsRepoEvents.setSettings(searchSettings)
        }
    }

    override fun logout(): Completable = settingsRepoEvents.logout()

}