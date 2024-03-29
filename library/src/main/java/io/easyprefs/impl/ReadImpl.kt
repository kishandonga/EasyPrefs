package io.easyprefs.impl

import android.content.SharedPreferences
import android.os.Build
import io.easyprefs.contract.Read
import io.easyprefs.enums.Encryption
import io.easyprefs.secure.Crypt
import org.json.JSONArray

class ReadImpl(
    private val pref: SharedPreferences,
    private val encType: Encryption
) : Read {

    override fun pref(): SharedPreferences {
        return pref
    }

    override fun content(key: String, defaultValue: Int): Int {
        return if (encType == Encryption.NONE) {
            pref.getInt(key, defaultValue)
        } else {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                pref.getInt(key, defaultValue)
            } else {
                decrypt(key, defaultValue.toString()).toInt()
            }
        }
    }

    override fun content(key: String, defaultValue: String): String {
        return if (encType == Encryption.NONE) {
            pref.getString(key, defaultValue) ?: defaultValue
        } else {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
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
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
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
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
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
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
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
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                pref.getStringSet(key, defaultValue) ?: defaultValue
            } else {
                val value = decrypt(key, "")
                return if (value.isEmpty()) {
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
        return if (encType == Encryption.NONE) {
            pref.all
        } else {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                pref.all
            } else {
                val map = mutableMapOf<String, Any?>()
                pref.all.keys.forEach {
                    val key = Crypt.encryptKey(it)
                    val value = decrypt(it, "")
                    if (isNumeric(value)) {
                        if (value.contains('.')) {
                            map[key] = value.toDoubleOrNull()
                        } else {
                            map[key] = value.toLongOrNull()
                        }
                    } else {
                        map[key] = value
                    }
                }
                map
            }
        }
    }

    private fun decrypt(key: String, defaultValue: String): String {
        val value = pref.getString(Crypt.encryptKey(key), defaultValue)
        return if (value == null) {
            defaultValue
        } else {
            return if (value == defaultValue) {
                defaultValue
            } else {
                Crypt.decrypt(key, value)
            }
        }
    }

    private fun isNumeric(toCheck: String): Boolean {
        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()
        return toCheck.matches(regex)
    }
}