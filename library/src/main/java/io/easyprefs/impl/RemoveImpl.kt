package io.easyprefs.impl

import android.content.SharedPreferences
import android.os.Build
import io.easyprefs.contract.Remove
import io.easyprefs.enums.Encryption
import io.easyprefs.secure.Crypt

class RemoveImpl(
    private val edit: SharedPreferences.Editor,
    private val encType: Encryption
) : Remove, AtomicImpl(edit) {

    override fun key(key: String): Remove {
        if (encType == Encryption.NONE) {
            edit.remove(key)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                edit.remove(key)
            } else {
                edit.remove(Crypt.encryptKey(key))
            }
        }
        return this
    }
}