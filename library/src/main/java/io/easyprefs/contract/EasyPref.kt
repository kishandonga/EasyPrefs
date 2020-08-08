package io.easyprefs.contract

import android.content.Context
import io.easyprefs.typedef.Encryption

interface EasyPref {
    fun write(context: Context, encType: Encryption, aesKey: String): Write
    fun writeOn(context: Context, fileName: String, encType: Encryption, aesKey: String): Write
    fun writeOn(
        context: Context,
        fileName: String,
        mode: Int, encType: Encryption, aesKey: String
    ): Write

    fun read(context: Context, encType: Encryption, aesKey: String): Read
    fun readOn(context: Context, fileName: String, encType: Encryption, aesKey: String): Read
    fun readOn(
        context: Context,
        fileName: String,
        mode: Int, encType: Encryption, aesKey: String
    ): Read

    fun edit(context: Context, encType: Encryption, aesKey: String): Edit
    fun editOn(context: Context, fileName: String, encType: Encryption, aesKey: String): Edit
    fun editOn(
        context: Context,
        fileName: String,
        mode: Int, encType: Encryption, aesKey: String
    ): Edit
}