package io.easyprefs.contract.provider

import android.content.Context
import io.easyprefs.contract.Write

interface WritePrefProvider {
    fun write(): Write
    fun write(fileName: String): Write
    fun write(fileName: String, mode: Int): Write

    fun write(context: Context): Write
    fun write(context: Context, fileName: String): Write
    fun write(context: Context, fileName: String, mode: Int): Write
}