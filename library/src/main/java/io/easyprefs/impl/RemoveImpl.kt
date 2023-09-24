package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Remove

class RemoveImpl(private val edit: SharedPreferences.Editor) : Remove, AtomicImpl(edit) {

    override fun key(key: String): Remove {
        edit.remove(key)
        return this
    }
}