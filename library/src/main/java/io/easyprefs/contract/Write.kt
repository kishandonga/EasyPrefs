package io.easyprefs.contract

interface Write {
    fun writeInt(key: String, value: Int): Boolean
    fun writeIntAsync(key: String, value: Int)

    fun writeString(key: String, value: String): Boolean
    fun writeStringAsync(key: String, value: String)

    fun writeLong(key: String, value: Long): Boolean
    fun writeLongAsync(key: String, value: Long)

    fun writeFloat(key: String, value: Float): Boolean
    fun writeFloatAsync(key: String, value: Float)

    fun writeDouble(key: String, value: Double): Boolean
    fun writeDoubleAsync(key: String, value: Double)

    fun writeBoolean(key: String, value: Boolean): Boolean
    fun writeBooleanAsync(key: String, value: Boolean)

    fun writeStringSet(key: String, value: Set<String>): Boolean
    fun writeStringSetAsync(key: String, value: Set<String>)
}