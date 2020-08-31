package io.easyprefs.contract.provider

import io.easyprefs.contract.Secure

interface SecurePrefProvider {
    fun securely(): Secure
    fun securely(aesKey: String): Secure
}