package io.easyprefs

import android.content.Context
import io.easyprefs.contract.Edit
import io.easyprefs.contract.Read
import io.easyprefs.contract.Secure
import io.easyprefs.contract.Write
import io.easyprefs.contract.provider.PrefProvider
import io.easyprefs.error.PrefsEditContextException
import io.easyprefs.error.PrefsReadContextException
import io.easyprefs.error.PrefsWriteContextException
import io.easyprefs.ext.Pass
import io.easyprefs.impl.EasyPrefImpl
import io.easyprefs.impl.SecureImpl
import io.easyprefs.typedef.Encryption

object Prefs : PrefProvider {

    private lateinit var context: Context

    override fun initializeApp(context: Context) {
        this.context = context.applicationContext
    }

    override fun securely(): Secure {
        return securely(Pass.empty)
    }

    override fun securely(aesKey: String): Secure {
        val secure = SecureImpl
        secure.context = context
        secure.aesKey = aesKey
        return secure
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
        return EasyPrefImpl.write(context, Encryption.NONE, Pass.empty)
    }

    override fun write(context: Context, fileName: String): Write {
        return EasyPrefImpl.writeOn(context, fileName, Encryption.NONE, Pass.empty)
    }

    override fun write(context: Context, fileName: String, mode: Int): Write {
        return EasyPrefImpl.writeOn(context, fileName, mode, Encryption.NONE, Pass.empty)
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
        return EasyPrefImpl.read(context, Encryption.NONE, Pass.empty)
    }

    override fun read(context: Context, fileName: String): Read {
        return EasyPrefImpl.readOn(context, fileName, Encryption.NONE, Pass.empty)
    }

    override fun read(context: Context, fileName: String, mode: Int): Read {
        return EasyPrefImpl.readOn(context, fileName, mode, Encryption.NONE, Pass.empty)
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
        return EasyPrefImpl.edit(context, Encryption.NONE, Pass.empty)
    }

    override fun edit(context: Context, fileName: String): Edit {
        return EasyPrefImpl.editOn(context, fileName, Encryption.NONE, Pass.empty)
    }

    override fun edit(context: Context, fileName: String, mode: Int): Edit {
        return EasyPrefImpl.editOn(context, fileName, mode, Encryption.NONE, Pass.empty)
    }
}