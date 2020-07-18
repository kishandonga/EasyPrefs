package io.easyprefs.contract

import android.content.Context
import androidx.annotation.NonNull

interface PrefProvider {
    fun write(): Write
    fun write(@NonNull fileName: String): Write
    fun write(@NonNull fileName: String, mode: Int): Write

    fun write(@NonNull context: Context): Write
    fun write(@NonNull context: Context, @NonNull fileName: String): Write
    fun write(@NonNull context: Context, @NonNull fileName: String, mode: Int): Write

    fun read(): Read
    fun read(@NonNull fileName: String): Read
    fun read(@NonNull fileName: String, mode: Int): Read

    fun read(@NonNull context: Context): Read
    fun read(@NonNull context: Context, @NonNull fileName: String): Read
    fun read(@NonNull context: Context, @NonNull fileName: String, mode: Int): Read

    fun edit(): Edit
    fun edit(@NonNull fileName: String): Edit
    fun edit(@NonNull fileName: String, mode: Int): Edit

    fun edit(@NonNull context: Context): Edit
    fun edit(@NonNull context: Context, @NonNull fileName: String): Edit
    fun edit(@NonNull context: Context, @NonNull fileName: String, mode: Int): Edit
}