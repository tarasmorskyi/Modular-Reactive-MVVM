package com.tarasmorskyi.data_model

data class SearchSettings(
    var section: String = "hot",
    var sort: String = "viral",
    var window: String = "dau",
    var mature: Boolean = false,
    var showViral: Boolean = true
)