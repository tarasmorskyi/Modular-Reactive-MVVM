package com.tarasmorskyi.localstorage

import android.content.Context
import android.content.SharedPreferences
import com.squareup.moshi.Moshi


class Storage private constructor(
    preferences: SharedPreferences, moshi: Moshi
) : MoshiStorage(preferences, moshi) {
    companion object {

        private var instance: Storage? = null

        @Synchronized
        fun getDefault(context: Context): Storage {
            if (instance == null) {
                instance = createInstance(context, null, Moshi.Builder().build())
            }
            return instance as Storage
        }

        @Synchronized
        private fun getDefault(context: Context, name: String): Storage {
            if (instance == null) {
                instance = createInstance(context, name, Moshi.Builder().build())
            }
            return instance as Storage
        }

        @Synchronized
        fun getDefault(context: Context, moshi: Moshi): Storage {
            if (instance == null) {
                instance = createInstance(context, context.packageName, moshi)
            }
            return instance as Storage
        }

        private fun createInstance(
            context: Context, sharedPreferencesName: String?,
            moshi: Moshi
        ): Storage {
            val sharedPreferences = context.getSharedPreferences(
                sharedPreferencesName ?: context.packageName + "_JsonStorage", Context.MODE_PRIVATE
            )
            return Storage(sharedPreferences, moshi)
        }
    }
}