package io.easyprefs.contract

interface Read {
    fun content(key: String, defaultValue: Int): Int
    fun content(key: String, defaultValue: String): String
    fun content(key: String, defaultValue: Long): Long
    fun content(key: String, defaultValue: Float): Float
    fun content(key: String, defaultValue: Double): Double
    fun content(key: String, defaultValue: Boolean): Boolean
    fun content(key: String, defaultValue: Set<String>): Set<String>
}