package io.easyprefs

import android.content.Context
import io.easyprefs.contract.PrefProvider
import io.easyprefs.contract.Read
import io.easyprefs.contract.Write
import io.easyprefs.impl.EasyPrefImpl

object Prefs : PrefProvider {

    private lateinit var context: Context

    fun initializeApp(context: Context) {
        this.context = context.applicationContext
    }

    override fun writable(): Write {
        return writable(context)
    }

    override fun writable(fileName: String): Write {
        return writable(context, fileName)
    }

    override fun writable(fileName: String, mode: Int): Write {
        return writable(context, fileName, mode)
    }

    override fun writable(context: Context): Write {
        return EasyPrefImpl.write(context)
    }

    override fun writable(context: Context, fileName: String): Write {
        return EasyPrefImpl.writeOn(context, fileName)
    }

    override fun writable(context: Context, fileName: String, mode: Int): Write {
        return EasyPrefImpl.writeOn(context, fileName, mode)
    }

    override fun readable(): Read {
        return readable(context)
    }

    override fun readable(fileName: String): Read {
        return readable(context, fileName)
    }

    override fun readable(fileName: String, mode: Int): Read {
        return readable(context, fileName, mode)
    }

    override fun readable(context: Context): Read {
        return EasyPrefImpl.read(context)
    }

    override fun readable(context: Context, fileName: String): Read {
        return EasyPrefImpl.readOn(context, fileName)
    }

    override fun readable(context: Context, fileName: String, mode: Int): Read {
        return EasyPrefImpl.readOn(context, fileName, mode)
    }
}