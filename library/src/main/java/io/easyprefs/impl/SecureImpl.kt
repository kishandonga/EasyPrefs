package io.easyprefs.impl

import android.content.Context
import io.easyprefs.contract.Has
import io.easyprefs.contract.Read
import io.easyprefs.contract.Secure
import io.easyprefs.contract.Write
import io.easyprefs.error.PrefsHasContextException
import io.easyprefs.error.PrefsReadContextException
import io.easyprefs.error.PrefsWriteContextException
import io.easyprefs.typedef.Encryption

object SecureImpl : Secure {

    var context: Context? = null

    override fun write(): Write {
        if (context != null) {
            return write(context!!)
        }
        throw PrefsWriteContextException()
    }

    override fun write(fileName: String): Write {
        if (context != null) {
            return write(context!!, fileName)
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
        if (context != null) {
            return read(context!!)
        }
        throw PrefsReadContextException()
    }

    override fun read(fileName: String): Read {
        if (context != null) {
            return read(context!!, fileName)
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
        if (context != null) {
            return has(context!!)
        }
        throw PrefsHasContextException()
    }

    override fun has(fileName: String): Has {
        if (context != null) {
            return has(context!!, fileName)
        }
        throw PrefsHasContextException()
    }

    override fun has(context: Context): Has {
        return EasyPrefImpl.has(context, Encryption.APPLY)
    }

    override fun has(context: Context, fileName: String): Has {
        return EasyPrefImpl.hasOn(context, fileName, Encryption.APPLY)
    }
}