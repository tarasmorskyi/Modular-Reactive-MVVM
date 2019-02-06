package com.tarasmorskyi.dataModel

data class SearchSettings(
    var section: String = HOT,
    var sort: String = VIRAL,
    var window: String = DAY,
    var mature: Boolean = false,
    var showViral: Boolean = true
) {
    companion object {
        const val HOT = "hot"
        const val TOP = "top"
        const val USER = "user"

        const val VIRAL = "viral"
        const val TIME = "time"

        const val DAY = "day"
        const val WEEK = "week"
        const val MONTH = "month"
        const val YEAR = "year"
        const val ALL = "all"
    }
}