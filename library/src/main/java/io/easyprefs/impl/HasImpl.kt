package io.easyprefs.impl

import android.content.SharedPreferences
import android.os.Build
import io.easyprefs.contract.Has
import io.easyprefs.enums.Encryption
import io.easyprefs.secure.Crypt

class HasImpl(
    private val pref: SharedPreferences,
    private val encType: Encryption
) : Has {

    override fun key(key: String): Boolean {
        return if (encType == Encryption.NONE) {
            pref.all.keys.contains(key)
        } else {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                pref.all.keys.contains(key)
            } else {
                pref.all.keys.contains(Crypt.encryptKey(key))
            }
        }
    }

    override fun empty(): Boolean {
        return pref.all.isEmpty()
    }
}