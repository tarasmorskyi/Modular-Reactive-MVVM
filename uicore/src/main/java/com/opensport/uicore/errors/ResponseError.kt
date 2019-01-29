package com.opensport.myapplication.utils.errors


class ResponseError : AppError {
    constructor(error: Throwable) : super(error)

    constructor(code: Int, errorBody: String) : super("error: $code, errorBody: $errorBody")
}