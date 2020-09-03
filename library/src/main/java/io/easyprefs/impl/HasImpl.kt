package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Has

class HasImpl(private val pref: SharedPreferences) : Has {

    override fun key(key: String): Boolean {
        return pref.all.keys.contains(key)
    }
}