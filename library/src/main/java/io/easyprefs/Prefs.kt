package io.easyprefs

import android.content.Context
import io.easyprefs.contract.Edit
import io.easyprefs.contract.PrefProvider
import io.easyprefs.contract.Read
import io.easyprefs.contract.Write
import io.easyprefs.error.PrefsEditContextException
import io.easyprefs.error.PrefsReadContextException
import io.easyprefs.error.PrefsWriteContextException
import io.easyprefs.impl.EasyPrefImpl

object Prefs : PrefProvider {

    private lateinit var context: Context

    fun initializeApp(context: Context) {
        this.context = context.applicationContext
    }

    override fun write(): Write {
        if (this::context.isInitialized) {
            return write(context)
        }
        throw PrefsWriteContextException()
    }

    override fun write(fileName: String): Write {
        if (this::context.isInitialized) {
            return write(context, fileName)
        }
        throw PrefsWriteContextException()
    }

    override fun write(fileName: String, mode: Int): Write {
        if (this::context.isInitialized) {
            return write(context, fileName, mode)
        }
        throw PrefsWriteContextException()
    }

    override fun write(context: Context): Write {
        return EasyPrefImpl.write(context)
    }

    override fun write(context: Context, fileName: String): Write {
        return EasyPrefImpl.writeOn(context, fileName)
    }

    override fun write(context: Context, fileName: String, mode: Int): Write {
        return EasyPrefImpl.writeOn(context, fileName, mode)
    }

    override fun read(): Read {
        if (this::context.isInitialized) {
            return read(context)
        }
        throw PrefsReadContextException()
    }

    override fun read(fileName: String): Read {
        if (this::context.isInitialized) {
            return read(context, fileName)
        }
        throw PrefsReadContextException()
    }

    override fun read(fileName: String, mode: Int): Read {
        if (this::context.isInitialized) {
            return read(context, fileName, mode)
        }
        throw PrefsReadContextException()
    }

    override fun read(context: Context): Read {
        return EasyPrefImpl.read(context)
    }

    override fun read(context: Context, fileName: String): Read {
        return EasyPrefImpl.readOn(context, fileName)
    }

    override fun read(context: Context, fileName: String, mode: Int): Read {
        return EasyPrefImpl.readOn(context, fileName, mode)
    }

    override fun edit(): Edit {
        if (this::context.isInitialized) {
            return edit(context)
        }
        throw PrefsEditContextException()
    }

    override fun edit(fileName: String): Edit {
        if (this::context.isInitialized) {
            return edit(context, fileName)
        }
        throw PrefsEditContextException()
    }

    override fun edit(fileName: String, mode: Int): Edit {
        if (this::context.isInitialized) {
            return edit(context, fileName, mode)
        }
        throw PrefsEditContextException()
    }

    override fun edit(context: Context): Edit {
        return EasyPrefImpl.edit(context)
    }

    override fun edit(context: Context, fileName: String): Edit {
        return EasyPrefImpl.editOn(context, fileName)
    }

    override fun edit(context: Context, fileName: String, mode: Int): Edit {
        return EasyPrefImpl.editOn(context, fileName, mode)
    }
}