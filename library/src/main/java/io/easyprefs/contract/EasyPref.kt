package io.easyprefs.contract

import android.content.Context
import io.easyprefs.enums.Encryption

interface EasyPref {
    fun write(context: Context, encType: Encryption): Write
    fun writeOn(context: Context, fileName: String, encType: Encryption): Write

    fun read(context: Context, encType: Encryption): Read
    fun readOn(context: Context, fileName: String, encType: Encryption): Read

    fun clear(context: Context): Clear
    fun clearOn(context: Context, fileName: String): Clear

    fun remove(context: Context): Remove
    fun removeOn(context: Context, fileName: String): Remove

    fun has(context: Context, encType: Encryption): Has
    fun hasOn(context: Context, fileName: String, encType: Encryption): Has
}