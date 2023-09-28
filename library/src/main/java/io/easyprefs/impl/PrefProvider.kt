package io.easyprefs.impl

import android.content.Context
import android.content.SharedPreferences
import io.easyprefs.enums.Encryption
import io.easyprefs.secure.EncryptedPref

object PrefProvider {

    private var fName: String = ""
    private lateinit var sharedPreferences: SharedPreferences

    fun getPref(
        context: Context,
        fileName: String,
        encType: Encryption
    ): SharedPreferences {
        return if (encType == Encryption.NONE) {
            pref(context, fileName)
        } else {
            return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                EncryptedPref.getPreferences(context, fileName)
            } else {
                pref(context, fileName)
            }
        }
    }

    fun getPrefEditor(
        context: Context,
        fileName: String,
        encType: Encryption
    ): SharedPreferences.Editor {
        return if (encType == Encryption.NONE) {
            prefEditor(context, fileName)
        } else {
            return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                EncryptedPref.getPreferences(context, fileName).edit()
            } else {
                prefEditor(context, fileName)
            }
        }
    }

    private fun pref(context: Context, fileName: String): SharedPreferences {
        if (this::sharedPreferences.isInitialized && fName.isNotEmpty() && fName == fileName) {
            return sharedPreferences
        }

        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
        return sharedPreferences
    }

    private fun prefEditor(
        context: Context,
        fileName: String
    ): SharedPreferences.Editor {
        return pref(context, fileName).edit()
    }
}