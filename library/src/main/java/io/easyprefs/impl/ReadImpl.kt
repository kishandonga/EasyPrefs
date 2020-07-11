package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Read

class ReadImpl(private val pref: SharedPreferences) : Read {

    override fun readInt(key: String, defaultValue: Int): Int {
        return pref.getInt(key, defaultValue)
    }

    override fun readString(key: String, defaultValue: String): String {
        return pref.getString(key, defaultValue) ?: defaultValue
    }

    override fun readLong(key: String, defaultValue: Long): Long {
        return pref.getLong(key, defaultValue)
    }

    override fun readFloat(key: String, defaultValue: Float): Float {
        return pref.getFloat(key, defaultValue)
    }

    override fun readDouble(key: String, defaultValue: Double): Double {
        return readString(key, defaultValue.toString()).toDouble()
    }

    override fun readBoolean(key: String, defaultValue: Boolean): Boolean {
        return pref.getBoolean(key, defaultValue)
    }

    override fun readStringSet(key: String, defaultValue: Set<String>): Set<String> {
        return pref.getStringSet(key, defaultValue) ?: defaultValue
    }
}