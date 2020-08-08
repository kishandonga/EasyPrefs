package io.easyprefs.contract.provider

import android.content.Context
import io.easyprefs.contract.Edit

interface EditPrefProvider {
    fun edit(): Edit
    fun edit(fileName: String): Edit
    fun edit(fileName: String, mode: Int): Edit

    fun edit(context: Context): Edit
    fun edit(context: Context, fileName: String): Edit
    fun edit(context: Context, fileName: String, mode: Int): Edit
}