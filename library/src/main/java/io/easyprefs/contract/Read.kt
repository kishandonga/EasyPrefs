package io.easyprefs.contract

interface Read {
    fun int(key: String, defaultValue: Int): Int
    fun string(key: String, defaultValue: String): String
    fun long(key: String, defaultValue: Long): Long
    fun float(key: String, defaultValue: Float): Float
    fun double(key: String, defaultValue: Double): Double
    fun boolean(key: String, defaultValue: Boolean): Boolean
    fun stringSet(key: String, defaultValue: Set<String>): Set<String>
}