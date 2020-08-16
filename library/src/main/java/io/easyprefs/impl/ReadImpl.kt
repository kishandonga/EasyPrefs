package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Read
import io.easyprefs.secure.Crypt
import io.easyprefs.typedef.Encryption

class ReadImpl(
    private val pref: SharedPreferences,
    private val encType: Encryption,
    private val aesKey: String
) : Read {

    override fun int(key: String, defaultValue: Int): Int {
        return if (encType == Encryption.NONE) {
            pref.getInt(key, defaultValue)
        } else {
            decrypt(key, defaultValue.toString()).toInt()
        }
    }

    private fun decrypt(key: String, defaultValue: String): String {
        var value = pref.getString(key, defaultValue) ?: defaultValue
        return if (aesKey.isEmpty()) {
            if (value != defaultValue) {
                value = Crypt.decrypt(key, value)
            }
            value
        } else {
            if (value != defaultValue) {
                value = Crypt.decrypt(aesKey, value)
            }
            value
        }
    }

    override fun string(key: String, defaultValue: String): String {
        return pref.getString(key, defaultValue) ?: defaultValue
    }

    override fun long(key: String, defaultValue: Long): Long {
        return pref.getLong(key, defaultValue)
    }

    override fun float(key: String, defaultValue: Float): Float {
        return pref.getFloat(key, defaultValue)
    }

    override fun double(key: String, defaultValue: Double): Double {
        return string(key, defaultValue.toString()).toDouble()
    }

    override fun boolean(key: String, defaultValue: Boolean): Boolean {
        return pref.getBoolean(key, defaultValue)
    }

    override fun stringSet(key: String, defaultValue: Set<String>): Set<String> {
        return pref.getStringSet(key, defaultValue) ?: defaultValue
    }
}