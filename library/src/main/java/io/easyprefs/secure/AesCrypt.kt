package io.easyprefs.secure

import android.util.Base64
import java.io.UnsupportedEncodingException
import java.security.GeneralSecurityException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

/**
 * Encrypt and decrypt messages using AES 256 bit encryption that are compatible with AESCrypt-ObjC and AESCrypt Ruby.
 */
@Suppress("unused")
object AesCrypt {

    //AESCrypt-ObjC uses CBC and PKCS7Padding
    private const val AES_MODE = "AES/CBC/PKCS7Padding"
    private const val CHARSET = "UTF-8"

    //AESCrypt-ObjC uses SHA-256 (and so a 256-bit key)
    private const val HASH_ALGORITHM = "SHA-256"

    //AESCrypt-ObjC uses blank IV (not the best security, but the aim here is compatibility)
    private val ivBytes = byteArrayOf(
        0x00,
        0x00,
        0x00,
        0x00,
        0x00,
        0x00,
        0x00,
        0x00,
        0x00,
        0x00,
        0x00,
        0x00,
        0x00,
        0x00,
        0x00,
        0x00
    )

    /**
     * Generates SHA256 hash of the password which is used as key
     *
     * @param password used to generated key
     * @return SHA256 of the password
     */
    @Throws(NoSuchAlgorithmException::class, UnsupportedEncodingException::class)
    private fun generateKey(password: String): SecretKeySpec {
        val digest = MessageDigest.getInstance(HASH_ALGORITHM)
        val bytes: ByteArray = password.toByteArray(Charsets.UTF_8)
        digest.update(bytes, 0, bytes.size)
        val key = digest.digest()
        return SecretKeySpec(key, "AES")
    }

    /**
     * Encrypt and encode message using 256-bit AES with key generated from password.
     *
     * @param password used to generated key
     * @param message  the thing you want to encrypt assumed String UTF-8
     * @return Base64 encoded CipherText
     */
    fun encrypt(password: String, message: String): String {
        try {
            val key = generateKey(password)
            val cipherText = encrypt(
                key,
                ivBytes,
                message.toByteArray(Charsets.UTF_8)
            )
            return Base64.encodeToString(cipherText, Base64.NO_WRAP)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return message
    }

    fun encrypt(password: String, bytes: ByteArray): ByteArray {
        try {
            val key = generateKey(password)
            return encrypt(
                key,
                ivBytes,
                bytes
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bytes
    }

    /**
     * More flexible AES encrypt that doesn't encode
     *
     * @param key     AES key typically 128, 192 or 256 bit
     * @param iv      Initiation Vector
     * @param message in bytes (assumed it's already been decoded)
     * @return Encrypted cipher text (not encoded)
     * @throws GeneralSecurityException if something goes wrong during encryption
     */
    @Throws(GeneralSecurityException::class)
    fun encrypt(key: SecretKeySpec, iv: ByteArray, message: ByteArray): ByteArray {
        val cipher = Cipher.getInstance(AES_MODE)
        val ivSpec = IvParameterSpec(iv)
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec)
        return cipher.doFinal(message)
    }

    fun decrypt(password: String, message: String): String {
        try {
            val key = generateKey(password)
            val decodedCipherText = Base64.decode(message, Base64.NO_WRAP)
            val decryptedBytes = decrypt(
                key,
                ivBytes,
                decodedCipherText
            )
            return String(decryptedBytes, Charsets.UTF_8)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return message
    }

    fun decrypt(password: String, bytes: ByteArray): ByteArray {
        try {
            val key = generateKey(password)
            return decrypt(
                key,
                ivBytes,
                bytes
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bytes
    }

    /**
     * More flexible AES decrypt that doesn't encode
     *
     * @param key               AES key typically 128, 192 or 256 bit
     * @param iv                Initiation Vector
     * @param decodedCipherText in bytes (assumed it's already been decoded)
     * @return Decrypted message cipher text (not encoded)
     * @throws GeneralSecurityException if something goes wrong during encryption
     */
    @Throws(GeneralSecurityException::class)
    fun decrypt(key: SecretKeySpec, iv: ByteArray, decodedCipherText: ByteArray): ByteArray {
        val cipher = Cipher.getInstance(AES_MODE)
        val ivSpec = IvParameterSpec(iv)
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec)
        return cipher.doFinal(decodedCipherText)
    }
}
