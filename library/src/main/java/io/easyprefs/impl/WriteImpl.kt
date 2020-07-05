package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Write

class WriteImpl(private val pref: SharedPreferences) : Write {

    override fun writeInt(key: String, value: Int): Boolean {
        return pref.edit().putInt(key, value).commit()
    }

    override fun writeIntAsync(key: String, value: Int) {
        pref.edit().putInt(key, value).apply()
    }

    override fun writeString(key: String, value: String): Boolean {
        return pref.edit().putString(key, value).commit()
    }

    override fun writeStringAsync(key: String, value: String) {
        pref.edit().putString(key, value).apply()
    }

    override fun writeLong(key: String, value: Long): Boolean {
        return pref.edit().putLong(key, value).commit()
    }

    override fun writeLongAsync(key: String, value: Long) {
        pref.edit().putLong(key, value).apply()
    }

    override fun writeFloat(key: String, value: Float): Boolean {
        return pref.edit().putFloat(key, value).commit()
    }

    override fun writeFloatAsync(key: String, value: Float) {
        pref.edit().putFloat(key, value).apply()
    }

    override fun writeDouble(key: String, value: Double): Boolean {
        return writeString(key, value.toString())
    }

    override fun writeDoubleAsync(key: String, value: Double) {
        writeStringAsync(key, value.toString())
    }

    override fun writeBoolean(key: String, value: Boolean): Boolean {
        return pref.edit().putBoolean(key, value).commit()
    }

    override fun writeBooleanAsync(key: String, value: Boolean) {
        pref.edit().putBoolean(key, value).apply()
    }

    override fun writeStringSet(key: String, value: Set<String>): Boolean {
        return pref.edit().putStringSet(key, value).commit()
    }

    override fun writeStringSetAsync(key: String, value: Set<String>) {
        pref.edit().putStringSet(key, value).apply()
    }
}