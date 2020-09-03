package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Remove

class RemoveImpl(private val edit: SharedPreferences.Editor) : Remove {

    override fun key(key: String): Remove {
        edit.remove(key)
        return this
    }

    override fun commit(): Boolean {
        return edit.commit()
    }

    override fun apply() {
        edit.apply()
    }
}