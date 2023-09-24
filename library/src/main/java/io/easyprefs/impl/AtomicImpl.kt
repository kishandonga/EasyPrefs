package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Atomic

open class AtomicImpl(private val edit: SharedPreferences.Editor) : Atomic {
    override fun commit(): Boolean {
        return edit.commit()
    }

    override fun apply() {
        edit.apply()
    }
}