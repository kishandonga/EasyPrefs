package io.easyprefs.contract

import android.content.Context
import androidx.annotation.NonNull

interface EasyPref {
    fun write(@NonNull context: Context): Write
    fun writeOn(@NonNull context: Context, @NonNull fileName: String): Write
    fun writeOn(
        @NonNull context: Context,
        @NonNull fileName: String,
        mode: Int
    ): Write

    fun read(@NonNull context: Context): Read
    fun readOn(@NonNull context: Context, @NonNull fileName: String): Read
    fun readOn(
        @NonNull context: Context,
        @NonNull fileName: String,
        mode: Int
    ): Read
}