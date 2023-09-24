package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Atomic
import io.easyprefs.contract.Clear

class ClearImpl(private val edit: SharedPreferences.Editor) : Clear, AtomicImpl(edit) {

    override fun all(): Atomic {
        edit.clear()
        return this
    }
}