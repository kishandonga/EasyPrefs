package io.easyprefs.secure.contract

interface CryptProvider {
    fun encrypt(key: String, value: String): String
    fun decrypt(key: String, value: String): String
    fun getKey(key: String): String
    fun encryptKey(key: String): String
}