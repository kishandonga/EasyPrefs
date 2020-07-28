package io.easyprefs.impl

import android.content.Context
import io.easyprefs.contract.EasyPref
import io.easyprefs.contract.Edit
import io.easyprefs.contract.Read
import io.easyprefs.contract.Write

object EasyPrefImpl : EasyPref {

    override fun write(context: Context): Write {
        return WriteImpl(
            context.getSharedPreferences(
                getFileName(context),
                Context.MODE_PRIVATE
            ).edit()
        )
    }

    override fun writeOn(context: Context, fileName: String): Write {
        return WriteImpl(
            context.getSharedPreferences(
                getFileNameOn(fileName),
                Context.MODE_PRIVATE
            ).edit()
        )
    }

    override fun writeOn(context: Context, fileName: String, mode: Int): Write {
        return WriteImpl(
            context.getSharedPreferences(
                getFileNameOn(fileName),
                mode
            ).edit()
        )
    }

    override fun read(context: Context): Read {
        return ReadImpl(
            context.getSharedPreferences(
                getFileName(context),
                Context.MODE_PRIVATE
            )
        )
    }

    override fun readOn(context: Context, fileName: String): Read {
        return ReadImpl(
            context.getSharedPreferences(
                getFileNameOn(fileName),
                Context.MODE_PRIVATE
            )
        )
    }

    override fun readOn(context: Context, fileName: String, mode: Int): Read {
        return ReadImpl(
            context.getSharedPreferences(
                getFileNameOn(fileName),
                mode
            )
        )
    }

    override fun edit(context: Context): Edit {
        return EditImpl(
            context.getSharedPreferences(
                getFileName(context),
                Context.MODE_PRIVATE
            ).edit()
        )
    }

    override fun editOn(context: Context, fileName: String): Edit {
        return EditImpl(
            context.getSharedPreferences(
                getFileNameOn(fileName),
                Context.MODE_PRIVATE
            ).edit()
        )
    }

    override fun editOn(context: Context, fileName: String, mode: Int): Edit {
        return EditImpl(
            context.getSharedPreferences(
                getFileNameOn(fileName),
                mode
            ).edit()
        )
    }

    private fun getFileName(context: Context): String {
        return "prefs_${context.packageName.replace(".", "_")}"
    }

    private fun getFileNameOn(fileName: String): String {
        return "prefs_${fileName}"
    }
}