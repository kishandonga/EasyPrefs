package io.easyprefs.contract.provider

import android.content.Context

interface PrefProvider : SecurePrefProvider,
    WritePrefProvider,
    ReadPrefProvider,
    EditPrefProvider {
    fun initializeApp(context: Context)
}