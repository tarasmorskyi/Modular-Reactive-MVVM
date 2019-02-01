package com.tarasmorskyi.myapplication.utils.errors

import android.annotation.TargetApi
import android.os.Build


class AppException : Exception {
    constructor()

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)

    constructor(cause: Throwable) : super(cause)

    @TargetApi(Build.VERSION_CODES.N)
    constructor(
        message: String, cause: Throwable, enableSuppression: Boolean,
        writableStackTrace: Boolean
    ) : super(message, cause, enableSuppression, writableStackTrace)
}
