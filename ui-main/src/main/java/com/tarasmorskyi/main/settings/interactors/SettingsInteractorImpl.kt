package com.tarasmorskyi.main.settings.interactors

import com.tarasmorskyi.dataModel.SearchSettings
import com.tarasmorskyi.main.R
import com.tarasmorskyi.main.settings.api.SettingsRepoEvents
import io.reactivex.Completable
import io.reactivex.Maybe
import javax.inject.Inject

class SettingsInteractorImpl @Inject constructor(
    private val settingsRepoEvents: SettingsRepoEvents
) : SettingsInteractor {

    override fun settings(): Maybe<SearchSettings> = settingsRepoEvents.settings()

    override fun setSettingsMature(mature: Boolean): Completable =
        settingsRepoEvents.settings().flatMapCompletable { searchSettings ->
            if (searchSettings.mature == mature)
                return@flatMapCompletable Completable.complete()

            searchSettings.mature = mature
            return@flatMapCompletable settingsRepoEvents.setSettings(searchSettings)
        }

    override fun setSettingsShowViral(isViral: Boolean): Completable =
        settingsRepoEvents.settings().flatMapCompletable { searchSettings ->
            if (searchSettings.showViral == isViral)
                return@flatMapCompletable Completable.complete()

            searchSettings.showViral = isViral
            return@flatMapCompletable settingsRepoEvents.setSettings(searchSettings)
        }

    override fun setSettingsFilter(filterId: Int): Completable =
        settingsRepoEvents.settings().flatMapCompletable { searchSettings ->
            var section: String = searchSettings.section
            var sort: String = searchSettings.sort
            var window: String = searchSettings.window
            when (filterId) {
                R.id.hot -> section = SearchSettings.HOT
                R.id.top -> section = SearchSettings.TOP
                R.id.user -> section = SearchSettings.USER

                R.id.viral -> sort = SearchSettings.VIRAL
                R.id.topSort -> sort = SearchSettings.TOP
                R.id.time -> sort = SearchSettings.TIME

                R.id.day -> window = SearchSettings.DAY
                R.id.week -> window = SearchSettings.WEEK
                R.id.month -> window = SearchSettings.MONTH
                R.id.year -> window = SearchSettings.YEAR
                R.id.all -> window = SearchSettings.ALL
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

    override fun logout(): Completable = settingsRepoEvents.logout()
}