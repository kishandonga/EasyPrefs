package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Read
import io.easyprefs.secure.Crypt
import io.easyprefs.typedef.Encryption
import org.json.JSONArray

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
        var value = pref.getString(key, null) ?: defaultValue
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
        return if (encType == Encryption.NONE) {
            pref.getString(key, defaultValue) ?: defaultValue
        } else {
            decrypt(key, defaultValue)
        }
    }

    override fun long(key: String, defaultValue: Long): Long {
        return if (encType == Encryption.NONE) {
            pref.getLong(key, defaultValue)
        } else {
            decrypt(key, defaultValue.toString()).toLong()
        }
    }

    override fun float(key: String, defaultValue: Float): Float {
        return if (encType == Encryption.NONE) {
            pref.getFloat(key, defaultValue)
        } else {
            decrypt(key, defaultValue.toString()).toFloat()
        }
    }

    override fun double(key: String, defaultValue: Double): Double {
        return string(key, defaultValue.toString()).toDouble()
    }

    override fun boolean(key: String, defaultValue: Boolean): Boolean {
        return if (encType == Encryption.NONE) {
            pref.getBoolean(key, defaultValue)
        } else {
            decrypt(key, defaultValue.toString()).toBoolean()
        }
    }

    override fun stringSet(key: String, defaultValue: Set<String>): Set<String> {
        return if (encType == Encryption.NONE) {
            return pref.getStringSet(key, defaultValue) ?: defaultValue
        } else {
            val value = decrypt(key, "")
            if (value.isEmpty()) {
                defaultValue
            } else {
                val set = mutableSetOf<String>()
                val array = JSONArray(value)
                for (i in 0 until array.length()) {
                    set.add(array.optString(i))
                }
                set
            }
        }
    }
}