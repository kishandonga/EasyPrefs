package io.easyprefs

import android.content.Context
import io.easyprefs.contract.Clear
import io.easyprefs.contract.Has
import io.easyprefs.contract.Read
import io.easyprefs.contract.Remove
import io.easyprefs.contract.Secure
import io.easyprefs.contract.Write
import io.easyprefs.error.PrefsClearContextException
import io.easyprefs.error.PrefsHasContextException
import io.easyprefs.error.PrefsReadContextException
import io.easyprefs.error.PrefsRemoveContextException
import io.easyprefs.error.PrefsSecurelyContextException
import io.easyprefs.error.PrefsWriteContextException
import io.easyprefs.impl.EasyPrefImpl
import io.easyprefs.impl.SecureImpl
import io.easyprefs.typedef.Encryption
import java.lang.ref.WeakReference

object Prefs {

    private lateinit var contextWeakReference: WeakReference<Context>

    @JvmStatic
    fun initializeApp(context: Context) {
        this.contextWeakReference = WeakReference(context.applicationContext)
    }

    //TODO: only for the API Level 23 Android M+ @RequiresApi(Build.VERSION_CODES.M)
    @JvmStatic
    fun securely(): Secure {
        val secure = SecureImpl
        if (isContextValid()) {
            secure.contextWeakReference = WeakReference(contextWeakReference.get())
        }
        throw PrefsSecurelyContextException()
    }

    @JvmStatic
    fun securely(context: Context): Secure {
        val secure = SecureImpl
        secure.contextWeakReference = WeakReference(context)
        return secure
    }

    @JvmStatic
    fun write(): Write {
        if (isContextValid()) {
            return write(contextWeakReference.get()!!)
        }
        throw PrefsWriteContextException()
    }

    @JvmStatic
    fun write(fileName: String): Write {
        if (isContextValid()) {
            return write(contextWeakReference.get()!!, fileName)
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
        if (isContextValid()) {
            return read(contextWeakReference.get()!!)
        }
        throw PrefsReadContextException()
    }

    @JvmStatic
    fun read(fileName: String): Read {
        if (isContextValid()) {
            return read(contextWeakReference.get()!!, fileName)
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
        if (isContextValid()) {
            return clear(contextWeakReference.get()!!)
        }
        throw PrefsClearContextException()
    }

    @JvmStatic
    fun clear(fileName: String): Clear {
        if (isContextValid()) {
            return clear(contextWeakReference.get()!!, fileName)
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
        if (isContextValid()) {
            return remove(contextWeakReference.get()!!)
        }
        throw PrefsRemoveContextException()
    }

    @JvmStatic
    fun remove(fileName: String): Remove {
        if (isContextValid()) {
            return remove(contextWeakReference.get()!!, fileName)
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
        if (isContextValid()) {
            return has(contextWeakReference.get()!!)
        }
        throw PrefsHasContextException()
    }

    @JvmStatic
    fun has(fileName: String): Has {
        if (isContextValid()) {
            return has(contextWeakReference.get()!!, fileName)
        }
        throw PrefsHasContextException()
    }

    @JvmStatic
    fun has(context: Context): Has {
        return EasyPrefImpl.has(context, Encryption.NONE)
    }

    @JvmStatic
    fun has(context: Context, fileName: String): Has {
        return EasyPrefImpl.hasOn(context, fileName, Encryption.NONE)
    }

    private fun isContextValid(): Boolean {
        return this::contextWeakReference.isInitialized && contextWeakReference.get() != null
    }
}
