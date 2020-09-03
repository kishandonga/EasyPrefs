package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Clear
import io.easyprefs.contract.provider.AtomicProvider

class ClearImpl(private val edit: SharedPreferences.Editor) : Clear {

    override fun all(): AtomicProvider {
        edit.clear()
        return this
    }

    override fun commit(): Boolean {
        return edit.commit()
    }

    override fun apply() {
        edit.apply()
    }
}