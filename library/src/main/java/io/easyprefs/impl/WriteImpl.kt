package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Write
import io.easyprefs.secure.Crypt
import io.easyprefs.typedef.Encryption
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray

class WriteImpl(
    private val edit: SharedPreferences.Editor,
    private val encType: Encryption,
    private val aesKey: String
) : Write {

    override fun int(key: String, value: Int): Boolean {
        return if (encType == Encryption.NONE) {
            edit.putInt(key, value).commit()
        } else {
            crypt(key, value.toString())
        }
    }

    private fun crypt(key: String, value: String): Boolean {
        return if (aesKey.isEmpty()) {
            edit.putString(key, Crypt.encrypt(key, value)).commit()
        } else {
            edit.putString(key, Crypt.encrypt(aesKey, value)).commit()
        }
    }

    private suspend fun cryptAsyncSuspend(key: String, value: String): String {
        return withContext(Dispatchers.IO) {
            if (aesKey.isEmpty()) {
                Crypt.encrypt(key, value)
            } else {
                Crypt.encrypt(aesKey, value)
            }
        }
    }

    private fun cryptAsync(key: String, value: String) {
        GlobalScope.launch(Dispatchers.Main) {
            val encrypted = cryptAsyncSuspend(key, value)
            edit.putString(key, encrypted).apply()
        }
    }

    override fun intAsync(key: String, value: Int) {
        if (encType == Encryption.NONE) {
            edit.putInt(key, value).apply()
        } else {
            cryptAsync(key, value.toString())
        }
    }

    override fun string(key: String, value: String): Boolean {
        return if (encType == Encryption.NONE) {
            edit.putString(key, value).commit()
        } else {
            crypt(key, value)
        }
    }

    override fun stringAsync(key: String, value: String) {
        if (encType == Encryption.NONE) {
            edit.putString(key, value).apply()
        } else {
            cryptAsync(key, value)
        }
    }

    override fun long(key: String, value: Long): Boolean {
        return if (encType == Encryption.NONE) {
            edit.putLong(key, value).commit()
        } else {
            crypt(key, value.toString())
        }
    }

    override fun longAsync(key: String, value: Long) {
        if (encType == Encryption.NONE) {
            edit.putLong(key, value).apply()
        } else {
            cryptAsync(key, value.toString())
        }
    }

    override fun float(key: String, value: Float): Boolean {
        return if (encType == Encryption.NONE) {
            edit.putFloat(key, value).commit()
        } else {
            crypt(key, value.toString())
        }
    }

    override fun floatAsync(key: String, value: Float) {
        if (encType == Encryption.NONE) {
            edit.putFloat(key, value).apply()
        } else {
            cryptAsync(key, value.toString())
        }
    }

    override fun double(key: String, value: Double): Boolean {
        return if (encType == Encryption.NONE) {
            string(key, value.toString())
        } else {
            crypt(key, value.toString())
        }
    }

    override fun doubleAsync(key: String, value: Double) {
        if (encType == Encryption.NONE) {
            stringAsync(key, value.toString())
        } else {
            cryptAsync(key, value.toString())
        }
    }

    override fun boolean(key: String, value: Boolean): Boolean {
        return if (encType == Encryption.NONE) {
            edit.putBoolean(key, value).commit()
        } else {
            crypt(key, value.toString())
        }
    }

    override fun booleanAsync(key: String, value: Boolean) {
        if (encType == Encryption.NONE) {
            edit.putBoolean(key, value).apply()
        } else {
            cryptAsync(key, value.toString())
        }
    }

    override fun stringSet(key: String, value: Set<String>): Boolean {
        return if (encType == Encryption.NONE) {
            edit.putStringSet(key, value).commit()
        } else {
            crypt(key, JSONArray(value).toString())
        }
    }

    override fun stringSetAsync(key: String, value: Set<String>) {
        if (encType == Encryption.NONE) {
            edit.putStringSet(key, value).apply()
        } else {
            cryptAsync(key, JSONArray(value).toString())
        }
    }
}
