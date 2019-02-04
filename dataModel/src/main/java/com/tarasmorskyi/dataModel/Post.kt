package com.tarasmorskyi.dataModel

import java.util.*

data class Post(
    val id: String = "",
    val title: String = "",
    val link: String = "",
    val images: List<Image> = Collections.emptyList()
)