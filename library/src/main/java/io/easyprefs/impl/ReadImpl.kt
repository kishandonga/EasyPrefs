package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Read

class ReadImpl(private val pref: SharedPreferences) : Read {

    override fun <T> read(key: String, default: T): T {
        return when (default) {
            is Int -> {
                pref.getInt(key, default)
            }
            is String -> {
                pref.getString(key, default)
            }
            is Long -> {
                pref.getLong(key, default)
            }
            else -> {
                default
            }
        } as T
    }
}