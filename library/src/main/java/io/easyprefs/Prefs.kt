package io.easyprefs

import android.content.Context
import io.easyprefs.contract.*
import io.easyprefs.error.*
import io.easyprefs.impl.EasyPrefImpl
import io.easyprefs.impl.SecureImpl
import io.easyprefs.typedef.Encryption

object Prefs {

    private lateinit var context: Context

    @JvmStatic
    fun initializeApp(context: Context) {
        this.context = context.applicationContext
    }

    @JvmStatic
    fun securely(): Secure {
        val secure = SecureImpl
        secure.context = context
        return secure
    }

    @JvmStatic
    fun write(): Write {
        if (this::context.isInitialized) {
            return write(context)
        }
        throw PrefsWriteContextException()
    }

    @JvmStatic
    fun write(fileName: String): Write {
        if (this::context.isInitialized) {
            return write(context, fileName)
        }
        throw PrefsWriteContextException()
    }

    @JvmStatic
    fun write(context: Context): Write {
        return EasyPrefImpl.write(context, Encryption.NONE)
    }

    @JvmStatic
    fun write(context: Context, fileName: String): Write {
        return EasyPrefImpl.writeOn(context, fileName, Encryption.NONE)
    }

    @JvmStatic
    fun read(): Read {
        if (this::context.isInitialized) {
            return read(context)
        }
        throw PrefsReadContextException()
    }

    @JvmStatic
    fun read(fileName: String): Read {
        if (this::context.isInitialized) {
            return read(context, fileName)
        }
        throw PrefsReadContextException()
    }

    @JvmStatic
    fun read(context: Context): Read {
        return EasyPrefImpl.read(context, Encryption.NONE)
    }

    @JvmStatic
    fun read(context: Context, fileName: String): Read {
        return EasyPrefImpl.readOn(context, fileName, Encryption.NONE)
    }

    @JvmStatic
    fun clear(): Clear {
        if (this::context.isInitialized) {
            return clear(context)
        }
        throw PrefsClearContextException()
    }

    @JvmStatic
    fun clear(fileName: String): Clear {
        if (this::context.isInitialized) {
            return clear(context, fileName)
        }
        throw PrefsClearContextException()
    }

    @JvmStatic
    fun clear(context: Context): Clear {
        return EasyPrefImpl.clear(context)
    }

    @JvmStatic
    fun clear(context: Context, fileName: String): Clear {
        return EasyPrefImpl.clearOn(context, fileName)
    }

    @JvmStatic
    fun remove(): Remove {
        if (this::context.isInitialized) {
            return remove(context)
        }
        throw PrefsRemoveContextException()
    }

    @JvmStatic
    fun remove(fileName: String): Remove {
        if (this::context.isInitialized) {
            return remove(context, fileName)
        }
        throw PrefsRemoveContextException()
    }

    @JvmStatic
    fun remove(context: Context): Remove {
        return EasyPrefImpl.remove(context)
    }

    @JvmStatic
    fun remove(context: Context, fileName: String): Remove {
        return EasyPrefImpl.removeOn(context, fileName)
    }

    @JvmStatic
    fun has(): Has {
        if (this::context.isInitialized) {
            return has(context)
        }
        throw PrefsHasContextException()
    }

    @JvmStatic
    fun has(fileName: String): Has {
        if (this::context.isInitialized) {
            return has(context, fileName)
        }
        throw PrefsHasContextException()
    }

    @JvmStatic
    fun has(context: Context): Has {
        return EasyPrefImpl.has(context)
    }

    @JvmStatic
    fun has(context: Context, fileName: String): Has {
        return EasyPrefImpl.hasOn(context, fileName)
    }
}