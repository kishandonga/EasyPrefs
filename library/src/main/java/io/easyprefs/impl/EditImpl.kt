package io.easyprefs.impl

import android.content.SharedPreferences
import io.easyprefs.contract.Edit

class EditImpl(private val edit: SharedPreferences.Editor) : Edit {

    override fun clear(): Boolean {
        return edit.clear().commit()
    }

    override fun clearAsync() {
        edit.clear().apply()
    }

    override fun remove(key: String): Boolean {
        return edit.remove(key).commit()
    }

    override fun removeAsync(key: String) {
        edit.remove(key).apply()
    }
}