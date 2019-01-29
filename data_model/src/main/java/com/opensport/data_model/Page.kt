package com.opensport.data_model

import java.util.*

data class Page(
    val id: String = "",
    val title: String = "",
    val link: String = "",
    val images: List<Image> = Collections.emptyList()
)