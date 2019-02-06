package com.tarasmorskyi.dataModel

import com.tarasmorskyi.dataModel.Constants.EMPTY_STRING
import java.util.*

data class Post(
    val id: String = EMPTY_STRING,
    val title: String = EMPTY_STRING,
    val link: String = EMPTY_STRING,
    val images: List<Image> = Collections.emptyList()
)