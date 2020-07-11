package io.easyprefs.impl

import android.content.Context
import io.easyprefs.contract.EasyPref
import io.easyprefs.contract.Read
import io.easyprefs.contract.Write

object EasyPrefImpl : EasyPref {

    override fun write(context: Context): Write {
        return WriteImpl(
            context.getSharedPreferences(
                context.packageName,
                Context.MODE_PRIVATE
            ).edit()
        )
    }

    override fun writeOn(context: Context, fileName: String): Write {
        return WriteImpl(
            context.getSharedPreferences(
                fileName,
                Context.MODE_PRIVATE
            ).edit()
        )
    }

    override fun writeOn(context: Context, fileName: String, mode: Int): Write {
        return WriteImpl(
            context.getSharedPreferences(
                fileName,
                mode
            ).edit()
        )
    }

    override fun read(context: Context): Read {
        return ReadImpl(
            context.getSharedPreferences(
                context.packageName,
                Context.MODE_PRIVATE
            )
        )
    }

    override fun readOn(context: Context, fileName: String): Read {
        return ReadImpl(
            context.getSharedPreferences(
                fileName,
                Context.MODE_PRIVATE
            )
        )
    }

    override fun readOn(context: Context, fileName: String, mode: Int): Read {
        return ReadImpl(
            context.getSharedPreferences(
                fileName,
                mode
            )
        )
    }
}