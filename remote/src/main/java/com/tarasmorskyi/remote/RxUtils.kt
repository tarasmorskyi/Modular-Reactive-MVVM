package com.tarasmorskyi.remote

import com.tarasmorskyi.myapplication.utils.errors.AppError
import com.tarasmorskyi.myapplication.utils.errors.ResponseError
import io.reactivex.MaybeTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import retrofit2.Response
import retrofit2.adapter.rxjava2.Result
import timber.log.Timber
import java.io.IOException
import java.net.SocketTimeoutException


internal object RxUtils {

    val OTHER_ERROR_CODE = 999
    private val NOT_AUTHORIZED = 401
    private val UNPROCESSABLE_ENTITY = 422

    fun <T> transformObservableResult(): ObservableTransformer<Result<T>, T> {
        return ObservableTransformer { response -> response.map { returnResultOrError(it) } }
    }

    fun <T> transformSingleResult(): SingleTransformer<Result<T>, T> {
        return SingleTransformer{ response -> response.map {returnResultOrError(it) } }
    }

    fun <T> transformMaybeResult(): MaybeTransformer<Result<T>, T> {
        return MaybeTransformer{ response -> response.map { returnResultOrError(it) } }
    }

    @Throws(AppError::class)
    private fun <T> returnResultOrError(result: Result<T>): T? {
        val response = result.response()
        if (!result.isError) {
            if (response != null && response.isSuccessful) {
                return response.body()
            } else {
                if (response != null) {
                    return handleServerError(response)
                }
            }
        } else {
            logErrorMessage(result)
            if (response != null) {
                return handleServerError(response)
            }
        }
        throw ResponseError(OTHER_ERROR_CODE, "network connection problem")
    }

    private fun <T> logErrorMessage(result: Result<T>) {
        if (result.error() is SocketTimeoutException) {
            Timber.w(result.error(), "socket timeout")
        } else if (result.error() is IOException) {
            if (result.error() is java.net.ConnectException) {
                Timber.w(result.error(), "connect exception")
            } else {
                Timber.w(result.error(), "other network io exception")
                val response = result.response()
                if (response != null) {
                    Timber.d("body: %s", response.raw().toString())
                }
            }
        } else {
            Timber.w(result.error(), "some other network exception")
        }
    }

    @Throws(AppError::class)
    private fun <T> handleServerError(response: Response<T>): T {
        throw ResponseError(response.code(), getBodyContent(response))
    }

    private fun <T> getBodyContent(response: Response<T>?): String {
        var bodyContent = "server error"
        if (response != null) {
            try {
                val body = response.errorBody()
                if (body != null) {
                    bodyContent = body.toString()
                }
            } catch (e: Exception) {
                Timber.d("error parsing error body")
                //ignored
            }

        }
        return bodyContent
    }
}