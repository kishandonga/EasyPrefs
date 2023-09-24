package io.easyprefs.contract

interface Remove : Atomic {
    fun key(key: String): Remove
}