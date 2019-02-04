package com.tarasmorskyi.localstorage

import android.annotation.SuppressLint
import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import java.io.IOException
import java.util.*


abstract class MoshiStorage @SuppressLint("CommitPrefEdits") internal constructor(
    private val preferences: SharedPreferences, private val moshi: Moshi
) {

    private val editor: SharedPreferences.Editor = preferences.edit()

    operator fun <T> set(type: String, payload: T, clazz: Class<T>) {
        editor.putString(type, moshi.adapter(clazz).toJson(payload))
        editor.commit()
    }

    operator fun <T> set(payload: T, clazz: Class<T>) {
        editor.putString(clazz.simpleName, moshi.adapter(clazz).toJson(payload))
        editor.commit()
    }

    @Throws(IOException::class)
    operator fun <T> get(type: String, clazz: Class<T>): T? {
        val json = preferences.getString(type, null) ?: return null
        return clazz.cast(moshi.adapter(clazz).fromJson(json))
    }

    @Throws(IOException::class)
    operator fun <T> get(clazz: Class<T>): T? {
        val json = preferences.getString(clazz.simpleName, null) ?: return null
        return clazz.cast(moshi.adapter(clazz).fromJson(json))
    }

    @Throws(IOException::class)
    fun <T> getList(type: String, clazz: Class<Array<T>>): List<T> {
        val json = preferences.getString(type, null) ?: return emptyList()
        val objects = moshi.adapter(clazz).fromJson(json)
        return Arrays.asList(*objects!!)
    }

    @Throws(IOException::class)
    fun <T> getPrimitiveList(type: String, clazz: Class<Array<T>>): Array<T>? {
        val json = preferences.getString(
            type,
            null
        ) ?: return emptyList<Any>().toTypedArray() as Array<T>
        return moshi.adapter(clazz).fromJson(json)
    }

    @Throws(IOException::class)
    fun <T> getList(type: String, clazz: Class<Array<T>>, defaultValue: List<T>): List<T> {
        val json = preferences.getString(type, null) ?: return defaultValue
        val objects = moshi.adapter(clazz).fromJson(json)
        return Arrays.asList(*objects!!)
    }

    @Throws(IOException::class)
    fun <T> getHashSet(type: String, clazz: Class<Array<T>>, defaultValue: HashSet<T>): HashSet<T> {
        val json = preferences.getString(type, null) ?: return defaultValue
        val objects = moshi.adapter(clazz).fromJson(json)

        return HashSet(Arrays.asList(*objects!!))
    }

    @Throws(IOException::class)
    operator fun <T> get(type: String, clazz: Class<T>, defaultValue: T): T? {
        val json = preferences.getString(type, null) ?: return defaultValue
        return clazz.cast(moshi.adapter(clazz).fromJson(json))
    }

    fun clearAll() {
        editor.clear()
        editor.commit()
    }

    fun clear(vararg values: String) {
        if (values.isEmpty()) {
            return
        }
        for (value in values) {
            editor.remove(value)
        }
        editor.commit()
    }

    fun setBoolean(type: String, payload: Boolean?) {
        editor.putBoolean(type, payload!!)
        editor.commit()
    }

    fun setLong(type: String, payload: Long) {
        editor.putLong(type, payload)
        editor.commit()
    }

    fun setInt(type: String, payload: Int) {
        editor.putInt(type, payload)
        editor.commit()
    }

    fun setFloat(type: String, payload: Float) {
        editor.putFloat(type, payload)
        editor.commit()
    }

    fun setString(type: String, payload: String) {
        editor.putString(type, payload)
        editor.commit()
    }

    fun getBoolean(type: String): Boolean {
        return preferences.getBoolean(type, false)
    }

    fun getLong(type: String): Long {
        return preferences.getLong(type, 0)
    }

    fun getInt(type: String): Int {
        return preferences.getInt(type, 0)
    }

    fun getFloat(type: String): Float {
        return preferences.getFloat(type, 0.0f)
    }

    fun getString(type: String): String? {
        return preferences.getString(type, null)
    }

    fun getString(type: String, defaultValue: String): String {
        return getString(type) ?: return defaultValue
    }
}