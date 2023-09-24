package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.provider.AtomicProvider

open class AtomicImpl(private val edit: SharedPreferences.Editor) : AtomicProvider {
    override fun commit(): Boolean {
        return edit.commit()
    }

    override fun apply() {
        edit.apply()
    }
}