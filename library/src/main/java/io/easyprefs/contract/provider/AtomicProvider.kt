package io.easyprefs.contract.provider

interface AtomicProvider {
    fun commit(): Boolean
    fun apply()
}