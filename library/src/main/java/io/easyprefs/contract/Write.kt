package io.easyprefs.contract

interface Write : Atomic {
    fun content(key: String, value: Int): Write
    fun content(key: String, value: String): Write
    fun content(key: String, value: Long): Write
    fun content(key: String, value: Float): Write
    fun content(key: String, value: Double): Write
    fun content(key: String, value: Boolean): Write
    fun content(key: String, value: Set<String>): Write
}