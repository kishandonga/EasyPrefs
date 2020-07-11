package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Write

class WriteImpl(private val edit: SharedPreferences.Editor) : Write {

    override fun writeInt(key: String, value: Int): Boolean {
        return edit.putInt(key, value).commit()
    }

    override fun writeIntAsync(key: String, value: Int) {
        edit.putInt(key, value).apply()
    }

    override fun writeString(key: String, value: String): Boolean {
        return edit.putString(key, value).commit()
    }

    override fun writeStringAsync(key: String, value: String) {
        edit.putString(key, value).apply()
    }

    override fun writeLong(key: String, value: Long): Boolean {
        return edit.putLong(key, value).commit()
    }

    override fun writeLongAsync(key: String, value: Long) {
        edit.putLong(key, value).apply()
    }

    override fun writeFloat(key: String, value: Float): Boolean {
        return edit.putFloat(key, value).commit()
    }

    override fun writeFloatAsync(key: String, value: Float) {
        edit.putFloat(key, value).apply()
    }

    override fun writeDouble(key: String, value: Double): Boolean {
        return writeString(key, value.toString())
    }

    override fun writeDoubleAsync(key: String, value: Double) {
        writeStringAsync(key, value.toString())
    }

    override fun writeBoolean(key: String, value: Boolean): Boolean {
        return edit.putBoolean(key, value).commit()
    }

    override fun writeBooleanAsync(key: String, value: Boolean) {
        edit.putBoolean(key, value).apply()
    }

    override fun writeStringSet(key: String, value: Set<String>): Boolean {
        return edit.putStringSet(key, value).commit()
    }

    override fun writeStringSetAsync(key: String, value: Set<String>) {
        edit.putStringSet(key, value).apply()
    }
}