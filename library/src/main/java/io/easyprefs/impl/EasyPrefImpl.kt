package io.easyprefs.impl

import android.content.Context
import io.easyprefs.contract.*
import io.easyprefs.typedef.Encryption

object EasyPrefImpl : EasyPref {

    override fun write(context: Context, encType: Encryption): Write {
        return WriteImpl(
            PrefProvider.getPrefEditor(context, getFileName(context), encType),
            encType
        )
    }

    override fun writeOn(
        context: Context,
        fileName: String,
        encType: Encryption
    ): Write {
        return WriteImpl(
            PrefProvider.getPrefEditor(context, getFileNameOn(fileName), encType),
            encType
        )
    }

    override fun read(context: Context, encType: Encryption): Read {
        return ReadImpl(
            PrefProvider.getPref(context, getFileName(context), encType),
            encType
        )
    }

    override fun readOn(
        context: Context,
        fileName: String,
        encType: Encryption
    ): Read {
        return ReadImpl(
            PrefProvider.getPref(context, getFileName(context), encType),
            encType
        )
    }

    override fun clear(context: Context): Clear {
        return ClearImpl(
            PrefProvider.getPrefEditor(
                context,
                getFileName(context),
                Encryption.NONE
            ),
        )
    }

    override fun clearOn(
        context: Context,
        fileName: String
    ): Clear {
        return ClearImpl(
            PrefProvider.getPrefEditor(
                context,
                getFileNameOn(fileName),
                Encryption.NONE
            )
        )
    }

    override fun remove(context: Context): Remove {
        return RemoveImpl(
            PrefProvider.getPrefEditor(
                context,
                getFileName(context),
                Encryption.NONE
            )
        )
    }

    override fun removeOn(context: Context, fileName: String): Remove {
        return RemoveImpl(
            PrefProvider.getPrefEditor(
                context,
                getFileNameOn(fileName),
                Encryption.NONE
            )
        )
    }

    override fun has(context: Context, encType: Encryption): Has {
        return HasImpl(
            PrefProvider.getPref(
                context,
                getFileName(context),
                encType
            ), encType
        )
    }

    override fun hasOn(context: Context, fileName: String, encType: Encryption): Has {
        return HasImpl(
            PrefProvider.getPref(
                context,
                getFileNameOn(fileName),
                encType
            ), encType
        )
    }

    private fun getFileName(context: Context): String {
        return "prefs_${context.packageName.replace(".", "_")}"
    }

    private fun getFileNameOn(fileName: String): String {
        return "prefs_${fileName}"
    }
}