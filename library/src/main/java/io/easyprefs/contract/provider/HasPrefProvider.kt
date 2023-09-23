package io.easyprefs.contract.provider

import android.content.Context
import io.easyprefs.contract.Has

interface HasPrefProvider {
    fun has(): Has
    fun has(fileName: String): Has
    fun has(context: Context): Has
    fun has(context: Context, fileName: String): Has
}