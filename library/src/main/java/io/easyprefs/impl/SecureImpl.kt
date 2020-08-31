package io.easyprefs.impl

import android.content.Context
import io.easyprefs.contract.Read
import io.easyprefs.contract.Secure
import io.easyprefs.contract.Write
import io.easyprefs.error.PrefsReadContextException
import io.easyprefs.error.PrefsWriteContextException
import io.easyprefs.ext.Pass
import io.easyprefs.typedef.Encryption

object SecureImpl : Secure {

    lateinit var context: Context
    var aesKey: String = Pass.empty

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
        return EasyPrefImpl.write(context, Encryption.AES, aesKey)
    }

    override fun write(context: Context, fileName: String): Write {
        return EasyPrefImpl.writeOn(context, fileName, Encryption.AES, aesKey)
    }

    override fun write(context: Context, fileName: String, mode: Int): Write {
        return EasyPrefImpl.writeOn(context, fileName, mode, Encryption.AES, aesKey)
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
        return EasyPrefImpl.read(context, Encryption.AES, aesKey)
    }

    override fun read(context: Context, fileName: String): Read {
        return EasyPrefImpl.readOn(context, fileName, Encryption.AES, aesKey)
    }

    override fun read(context: Context, fileName: String, mode: Int): Read {
        return EasyPrefImpl.readOn(context, fileName, mode, Encryption.AES, aesKey)
    }
}