package io.easyprefs.contract

interface Read {
    fun readInt(key: String, defaultValue: Int): Int
    fun readString(key: String, defaultValue: String): String
    fun readLong(key: String, defaultValue: Long): Long
    fun readFloat(key: String, defaultValue: Float): Float
    fun readDouble(key: String, defaultValue: Double): Double
    fun readBoolean(key: String, defaultValue: Boolean): Boolean
    fun readStringSet(key: String, defaultValue: Set<String>): Set<String>
}