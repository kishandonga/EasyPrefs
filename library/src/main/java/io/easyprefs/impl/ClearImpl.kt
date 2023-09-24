package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Clear
import io.easyprefs.contract.provider.AtomicProvider

class ClearImpl(private val edit: SharedPreferences.Editor) : Clear, AtomicImpl(edit) {

    override fun all(): AtomicProvider {
        edit.clear()
        return this
    }
}