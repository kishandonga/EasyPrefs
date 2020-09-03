package io.easyprefs.contract

import io.easyprefs.contract.provider.AtomicProvider

interface Remove : AtomicProvider {
    fun key(key: String): Remove
}