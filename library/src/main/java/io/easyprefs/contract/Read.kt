package io.easyprefs.contract

interface Read {
    fun <T> read(key: String, default: T): T
}