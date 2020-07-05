package io.easyprefs.contract

import android.content.Context
import androidx.annotation.NonNull

interface PrefProvider {
    fun writable(): Write
    fun writable(@NonNull fileName: String): Write
    fun writable(@NonNull fileName: String, mode: Int): Write

    fun writable(@NonNull context: Context): Write
    fun writable(@NonNull context: Context, @NonNull fileName: String): Write
    fun writable(@NonNull context: Context, @NonNull fileName: String, mode: Int): Write

    fun readable(): Read
    fun readable(@NonNull fileName: String): Read
    fun readable(@NonNull fileName: String, mode: Int): Read

    fun readable(@NonNull context: Context): Read
    fun readable(@NonNull context: Context, @NonNull fileName: String): Read
    fun readable(@NonNull context: Context, @NonNull fileName: String, mode: Int): Read
}