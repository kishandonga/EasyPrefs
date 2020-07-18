package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Write

class WriteImpl(private val edit: SharedPreferences.Editor) : Write {

    override fun int(key: String, value: Int): Boolean {
        return edit.putInt(key, value).commit()
    }

    override fun intAsync(key: String, value: Int) {
        edit.putInt(key, value).apply()
    }

    override fun string(key: String, value: String): Boolean {
        return edit.putString(key, value).commit()
    }

    override fun stringAsync(key: String, value: String) {
        edit.putString(key, value).apply()
    }

    override fun long(key: String, value: Long): Boolean {
        return edit.putLong(key, value).commit()
    }

    override fun longAsync(key: String, value: Long) {
        edit.putLong(key, value).apply()
    }

    override fun float(key: String, value: Float): Boolean {
        return edit.putFloat(key, value).commit()
    }

    override fun floatAsync(key: String, value: Float) {
        edit.putFloat(key, value).apply()
    }

    override fun double(key: String, value: Double): Boolean {
        return string(key, value.toString())
    }

    override fun doubleAsync(key: String, value: Double) {
        stringAsync(key, value.toString())
    }

    override fun boolean(key: String, value: Boolean): Boolean {
        return edit.putBoolean(key, value).commit()
    }

    override fun booleanAsync(key: String, value: Boolean) {
        edit.putBoolean(key, value).apply()
    }

    override fun stringSet(key: String, value: Set<String>): Boolean {
        return edit.putStringSet(key, value).commit()
    }

    override fun stringSetAsync(key: String, value: Set<String>) {
        edit.putStringSet(key, value).apply()
    }
}