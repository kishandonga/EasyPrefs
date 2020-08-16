package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Edit

class EditImpl(private val pref: SharedPreferences) : Edit {

    override fun clear(): Boolean {
        return pref.edit().clear().commit()
    }

    override fun clearAsync() {
        pref.edit().clear().apply()
    }

    override fun remove(key: String): Boolean {
        return pref.edit().remove(key).commit()
    }

    override fun removeAsync(key: String) {
        pref.edit().remove(key).apply()
    }

    override fun hasKey(key: String): Boolean {
        return pref.all.keys.contains(key)
    }
}