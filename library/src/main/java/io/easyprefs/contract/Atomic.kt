package io.easyprefs.contract

interface Atomic {
    fun commit(): Boolean
    fun apply()
}