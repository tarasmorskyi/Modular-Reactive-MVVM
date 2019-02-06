package com.tarasmorskyi.dataModel

import com.tarasmorskyi.dataModel.Constants.EMPTY_STRING

data class UserAuthenticationData(
    val accessToken: String = EMPTY_STRING,
    val expiresIn: Long = 0,
    val tokenType: String = EMPTY_STRING,
    val refreshToken: String = EMPTY_STRING,
    val accountUsername: String = EMPTY_STRING,
    val accountId: Long = 0
)