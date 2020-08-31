package io.easyprefs.contract.provider

import android.content.Context
import io.easyprefs.contract.Read

interface ReadPrefProvider {
    fun read(): Read
    fun read(fileName: String): Read
    fun read(fileName: String, mode: Int): Read

    fun read(context: Context): Read
    fun read(context: Context, fileName: String): Read
    fun read(context: Context, fileName: String, mode: Int): Read
}