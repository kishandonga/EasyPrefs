package io.easyprefs.contract

interface Write {
    fun int(key: String, value: Int): Boolean
    fun intAsync(key: String, value: Int)

    fun string(key: String, value: String): Boolean
    fun stringAsync(key: String, value: String)

    fun long(key: String, value: Long): Boolean
    fun longAsync(key: String, value: Long)

    fun float(key: String, value: Float): Boolean
    fun floatAsync(key: String, value: Float)

    fun double(key: String, value: Double): Boolean
    fun doubleAsync(key: String, value: Double)

    fun boolean(key: String, value: Boolean): Boolean
    fun booleanAsync(key: String, value: Boolean)

    fun stringSet(key: String, value: Set<String>): Boolean
    fun stringSetAsync(key: String, value: Set<String>)
}