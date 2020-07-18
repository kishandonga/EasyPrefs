package io.easyprefs.contract

interface Edit {
    fun clear(): Boolean
    fun clearAsync()

    fun remove(key: String): Boolean
    fun removeAsync(key: String)
}