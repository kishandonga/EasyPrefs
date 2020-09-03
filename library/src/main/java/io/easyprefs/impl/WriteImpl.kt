package io.easyprefs.impl

import android.content.SharedPreferences
import android.os.Build
import io.easyprefs.contract.Write
import io.easyprefs.secure.Crypt
import io.easyprefs.typedef.Encryption
import org.json.JSONArray

class WriteImpl(
    private val edit: SharedPreferences.Editor,
    private val encType: Encryption
) : Write {

    override fun content(key: String, value: Int): Write {
        if (encType == Encryption.NONE) {
            edit.putInt(key, value)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                edit.putInt(key, value)
            } else {
                crypt(key, value.toString())
            }
        }
        return this
    }

    private fun crypt(key: String, value: String) {
        edit.putString(key, Crypt.encrypt(key, value))
    }

    override fun content(key: String, value: String): Write {
        if (encType == Encryption.NONE) {
            edit.putString(key, value)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                edit.putString(key, value)
            } else {
                crypt(key, value)
            }
        }
        return this
    }

    override fun content(key: String, value: Long): Write {
        if (encType == Encryption.NONE) {
            edit.putLong(key, value)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                edit.putLong(key, value)
            } else {
                crypt(key, value.toString())
            }
        }
        return this
    }

    override fun content(key: String, value: Float): Write {
        if (encType == Encryption.NONE) {
            edit.putFloat(key, value)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                edit.putFloat(key, value)
            } else {
                crypt(key, value.toString())
            }
        }
        return this
    }

    override fun content(key: String, value: Double): Write {
        content(key, value.toString())
        return this
    }

    override fun content(key: String, value: Boolean): Write {
        if (encType == Encryption.NONE) {
            edit.putBoolean(key, value)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                edit.putBoolean(key, value)
            } else {
                crypt(key, value.toString())
            }
        }
        return this
    }

    override fun content(key: String, value: Set<String>): Write {
        if (encType == Encryption.NONE) {
            edit.putStringSet(key, value)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                edit.putStringSet(key, value)
            } else {
                crypt(key, JSONArray(value).toString())
            }
        }
        return this
    }

    override fun commit(): Boolean {
        return edit.commit()
    }

    override fun apply() {
        edit.apply()
    }
}

