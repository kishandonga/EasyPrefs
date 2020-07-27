package io.easyprefs.contract

import android.content.Context

interface EasyPref {
    fun write(context: Context): Write
    fun writeOn(context: Context, fileName: String): Write
    fun writeOn(
        context: Context,
        fileName: String,
        mode: Int
    ): Write

    fun read(context: Context): Read
    fun readOn(context: Context, fileName: String): Read
    fun readOn(
        context: Context,
        fileName: String,
        mode: Int
    ): Read

    fun edit(context: Context): Edit
    fun editOn(context: Context, fileName: String): Edit
    fun editOn(
        context: Context,
        fileName: String,
        mode: Int
    ): Edit
}