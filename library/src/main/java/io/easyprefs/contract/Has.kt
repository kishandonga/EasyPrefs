package io.easyprefs.contract

interface Has {
    fun key(key: String): Boolean
    fun empty(): Boolean
}