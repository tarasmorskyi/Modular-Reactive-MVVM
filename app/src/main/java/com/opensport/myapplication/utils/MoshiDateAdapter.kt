package com.opensport.myapplication.utils

import com.squareup.moshi.*
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import java.io.IOException
import java.util.regex.Pattern


class MoshiDateAdapter : JsonAdapter<LocalDateTime>() {

    @FromJson
    @Synchronized
    @Throws(IOException::class)
    override fun fromJson(reader: JsonReader): LocalDateTime? {
        val string = reader.nextString()
        if (string != null && string.length > 3) {
            val temporal = getPattern(string).parse(string)
            return LocalDateTime.from(temporal)
        }
        return null
    }

    private fun getPattern(string: CharSequence): DateTimeFormatter {
        return if (RE_FULL.matcher(string).matches()) {
            DateTimeFormatter.ISO_LOCAL_DATE_TIME
        } else if (RE_FULL_NO_SEC.matcher(string).matches()) {
            YYYY_MM_DDTHH_MM
        } else if (RE_FULL_NO_T.matcher(string).matches()) {
            YYYY_MM_DD_HH_MM_SS
        } else if (RE_FULL_NO_T_NO_SEC.matcher(string).matches()) {
            YYYY_MM_DD_HH_MM
        } else if (RE_DATE.matcher(string).matches()) {
            DateTimeFormatter.ISO_LOCAL_DATE
        } else {
            DateTimeFormatter.ISO_TIME
        }
    }

    @ToJson
    @Synchronized
    @Throws(IOException::class)
    override fun toJson(writer: JsonWriter?, value: LocalDateTime?) {
        val string = value.toString()
        writer!!.value(string)
    }

    companion object {

        private val RE_FULL = Pattern.compile("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}")
        private val RE_FULL_NO_T = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")
        private val RE_FULL_NO_SEC = Pattern.compile("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}")
        private val RE_FULL_NO_T_NO_SEC = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")
        private val RE_DATE = Pattern.compile("\\d{4}-\\d{2}-\\d{2}")

        private val YYYY_MM_DDTHH_MM = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
        private val YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        private val YYYY_MM_DD_HH_MM = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    }
}