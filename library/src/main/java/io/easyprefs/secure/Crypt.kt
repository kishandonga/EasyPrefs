package io.easyprefs.secure

import io.easyprefs.secure.contract.CryptProvider

object Crypt : CryptProvider {

    override fun encrypt(key: String, value: String): String {
        return AesCrypt.encrypt(key, value)
    }

    override fun decrypt(key: String, value: String): String {
        return AesCrypt.decrypt(key, value)
    }
}