package com.tarasmorskyi.dataModel

data class UserAuthenticationData(
    val accessToken: String = "",
    val expiresIn: Long = 0,
    val tokenType: String = "",
    val refreshToken: String = "",
    val accountUsername: String = "",
    val accountId: Long = 0
)