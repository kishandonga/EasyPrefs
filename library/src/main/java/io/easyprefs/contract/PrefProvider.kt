package io.easyprefs.contract

import android.content.Context

interface PrefProvider {
    fun write(): Write
    fun write(fileName: String): Write
    fun write(fileName: String, mode: Int): Write

    fun write(context: Context): Write
    fun write(context: Context, fileName: String): Write
    fun write(context: Context, fileName: String, mode: Int): Write

    fun read(): Read
    fun read(fileName: String): Read
    fun read(fileName: String, mode: Int): Read

    fun read(context: Context): Read
    fun read(context: Context, fileName: String): Read
    fun read(context: Context, fileName: String, mode: Int): Read

    fun edit(): Edit
    fun edit(fileName: String): Edit
    fun edit(fileName: String, mode: Int): Edit

    fun edit(context: Context): Edit
    fun edit(context: Context, fileName: String): Edit
    fun edit(context: Context, fileName: String, mode: Int): Edit
}