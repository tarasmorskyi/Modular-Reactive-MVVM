package com.opensport.myapplication.utils

import com.squareup.moshi.JsonAdapter


abstract class MyAdapterFactory : JsonAdapter.Factory {
    companion object {

        fun create(): JsonAdapter.Factory {
            return JsonAdapter.Factory { _, _, _ -> null }
        }
    }
}