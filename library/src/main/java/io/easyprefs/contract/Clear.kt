package io.easyprefs.contract

import io.easyprefs.contract.provider.AtomicProvider

interface Clear : AtomicProvider {
    fun all() : AtomicProvider
}