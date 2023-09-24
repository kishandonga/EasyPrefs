package io.easyprefs.impl

import android.content.Context
import io.easyprefs.contract.Has
import io.easyprefs.contract.Read
import io.easyprefs.contract.Remove
import io.easyprefs.contract.SecurePref
import io.easyprefs.contract.Write
import io.easyprefs.enums.Encryption
import io.easyprefs.error.PrefsHasContextException
import io.easyprefs.error.PrefsReadContextException
import io.easyprefs.error.PrefsRemoveContextException
import io.easyprefs.error.PrefsWriteContextException
import java.lang.ref.WeakReference

object SecurePrefImpl : SecurePref {

    lateinit var contextWeakReference: WeakReference<Context>

    override fun write(): Write {
        if (isContextValid()) {
            return write(contextWeakReference.get()!!)
        }
        throw PrefsWriteContextException()
    }

    override fun write(fileName: String): Write {
        if (isContextValid()) {
            return write(contextWeakReference.get()!!, fileName)
        }
        throw PrefsWriteContextException()
    }

    override fun write(context: Context): Write {
        return EasyPrefImpl.write(context, Encryption.APPLY)
    }

    override fun write(context: Context, fileName: String): Write {
        return EasyPrefImpl.writeOn(context, fileName, Encryption.APPLY)
    }

    override fun read(): Read {
        if (isContextValid()) {
            return read(contextWeakReference.get()!!)
        }
        throw PrefsReadContextException()
    }

    override fun read(fileName: String): Read {
        if (isContextValid()) {
            return read(contextWeakReference.get()!!, fileName)
        }
        throw PrefsReadContextException()
    }

    override fun read(context: Context): Read {
        return EasyPrefImpl.read(context, Encryption.APPLY)
    }

    override fun read(context: Context, fileName: String): Read {
        return EasyPrefImpl.readOn(context, fileName, Encryption.APPLY)
    }

    override fun has(): Has {
        if (isContextValid()) {
            return has(contextWeakReference.get()!!)
        }
        throw PrefsHasContextException()
    }

    override fun has(fileName: String): Has {
        if (isContextValid()) {
            return has(contextWeakReference.get()!!, fileName)
        }
        throw PrefsHasContextException()
    }

    override fun has(context: Context): Has {
        return EasyPrefImpl.has(context, Encryption.APPLY)
    }

    override fun has(context: Context, fileName: String): Has {
        return EasyPrefImpl.hasOn(context, fileName, Encryption.APPLY)
    }

    override fun remove(): Remove {
        if (isContextValid()) {
            return remove(contextWeakReference.get()!!)
        }
        throw PrefsRemoveContextException()
    }

    override fun remove(fileName: String): Remove {
        if (isContextValid()) {
            return remove(contextWeakReference.get()!!, fileName)
        }
        throw PrefsRemoveContextException()
    }

    override fun remove(context: Context): Remove {
        return EasyPrefImpl.remove(context, Encryption.APPLY)
    }

    override fun remove(context: Context, fileName: String): Remove {
        return EasyPrefImpl.removeOn(context, fileName, Encryption.APPLY)
    }

    private fun isContextValid(): Boolean {
        return this::contextWeakReference.isInitialized && contextWeakReference.get() != null
    }
}