package io.easyprefs

import android.content.Context
import io.easyprefs.contract.Edit
import io.easyprefs.contract.PrefProvider
import io.easyprefs.contract.Read
import io.easyprefs.contract.Write
import io.easyprefs.impl.EasyPrefImpl

object Prefs : PrefProvider {

    private lateinit var context: Context

    fun initializeApp(context: Context) {
        this.context = context.applicationContext
    }

    override fun write(): Write {
        return write(context)
    }

    override fun write(fileName: String): Write {
        return write(context, fileName)
    }

    override fun write(fileName: String, mode: Int): Write {
        return write(context, fileName, mode)
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
        return read(context)
    }

    override fun read(fileName: String): Read {
        return read(context, fileName)
    }

    override fun read(fileName: String, mode: Int): Read {
        return read(context, fileName, mode)
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
        return edit(context)
    }

    override fun edit(fileName: String): Edit {
        return edit(context, fileName)
    }

    override fun edit(fileName: String, mode: Int): Edit {
        return edit(context, fileName, mode)
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