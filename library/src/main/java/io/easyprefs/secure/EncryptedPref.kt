package io.easyprefs.secure

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
object EncryptedPref {

    private var fName: String = ""
    private lateinit var sharedPreferences: SharedPreferences

    fun getPreferences(context: Context, fileName: String): SharedPreferences {

        if (this::sharedPreferences.isInitialized && fName.isNotEmpty() && fName == fileName) {
            return sharedPreferences
        }

        // Step 1: Create or retrieve the Master Key for encryption/decryption
        val masterKey = MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()

        // Step 2: Initialize/open an instance of EncryptedSharedPreferences
        sharedPreferences = EncryptedSharedPreferences.create(
            context, fileName, masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        return sharedPreferences
    }
}