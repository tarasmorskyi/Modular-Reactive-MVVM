package com.tarasmorskyi.data_model

import java.util.*

data class Post(
    val id: String = "",
    val title: String = "",
    val link: String = "",
    val images: List<Image> = Collections.emptyList()
)