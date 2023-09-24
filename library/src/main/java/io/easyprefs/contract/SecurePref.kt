package io.easyprefs.contract

import android.content.Context

interface SecurePref {
    fun write(): Write
    fun write(fileName: String): Write
    fun write(context: Context): Write
    fun write(context: Context, fileName: String): Write

    fun read(): Read
    fun read(fileName: String): Read
    fun read(context: Context): Read
    fun read(context: Context, fileName: String): Read

    fun has(): Has
    fun has(fileName: String): Has
    fun has(context: Context): Has
    fun has(context: Context, fileName: String): Has

    fun remove(): Remove
    fun remove(fileName: String): Remove
    fun remove(context: Context): Remove
    fun remove(context: Context, fileName: String): Remove
}