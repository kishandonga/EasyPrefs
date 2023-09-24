package io.easyprefs.impl

import android.content.SharedPreferences
import android.os.Build
import io.easyprefs.contract.Read
import io.easyprefs.secure.Crypt
import io.easyprefs.typedef.Encryption
import org.json.JSONArray

class ReadImpl(
    private val pref: SharedPreferences,
    private val encType: Encryption
) : Read {

    override fun content(key: String, defaultValue: Int): Int {
        return if (encType == Encryption.NONE) {
            pref.getInt(key, defaultValue)
        } else {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                pref.getInt(key, defaultValue)
            } else {
                decrypt(key, defaultValue.toString()).toInt()
            }
        }
    }

    private fun decrypt(key: String, defaultValue: String): String {
        var value = pref.getString(Crypt.encryptKey(key), null) ?: defaultValue
        if (value != defaultValue) {
            value = Crypt.decrypt(key, value)
        }
        return value
    }

    override fun content(key: String, defaultValue: String): String {
        return if (encType == Encryption.NONE) {
            pref.getString(key, defaultValue) ?: defaultValue
        } else {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                pref.getString(key, defaultValue) ?: defaultValue
            } else {
                decrypt(key, defaultValue)
            }
        }
    }

    override fun content(key: String, defaultValue: Long): Long {
        return if (encType == Encryption.NONE) {
            pref.getLong(key, defaultValue)
        } else {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                pref.getLong(key, defaultValue)
            } else {
                decrypt(key, defaultValue.toString()).toLong()
            }
        }
    }

    override fun content(key: String, defaultValue: Float): Float {
        return if (encType == Encryption.NONE) {
            pref.getFloat(key, defaultValue)
        } else {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                pref.getFloat(key, defaultValue)
            } else {
                decrypt(key, defaultValue.toString()).toFloat()
            }
        }
    }

    override fun content(key: String, defaultValue: Double): Double {
        return content(key, defaultValue.toString()).toDouble()
    }

    override fun content(key: String, defaultValue: Boolean): Boolean {
        return if (encType == Encryption.NONE) {
            pref.getBoolean(key, defaultValue)
        } else {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                pref.getBoolean(key, defaultValue)
            } else {
                decrypt(key, defaultValue.toString()).toBoolean()
            }
        }
    }

    override fun content(key: String, defaultValue: Set<String>): Set<String> {
        return if (encType == Encryption.NONE) {
            pref.getStringSet(key, defaultValue) ?: defaultValue
        } else {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                pref.getStringSet(key, defaultValue) ?: defaultValue
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

    override fun allContent(): Map<String, *> {
        return pref.all
    }
}