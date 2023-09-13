package infrastructure.student

import domain.student.PasswordCipher
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class PasswordCipherMD5: PasswordCipher {

    override fun encryptPassword(password: String): String {
        try {
            val md = MessageDigest.getInstance("MD5")
            md.update(password.toByte())
            val bytes = md.digest()
            val sb = StringBuilder()
            for (i in bytes.indices) {
               // sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1))
            }
            return sb.toString()
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException("erro ao gerar hash da senha")
        }
    }

    override fun validateCipherPassword(cipherPassword: String, openPassword: String): Boolean {
       return cipherPassword == encryptPassword(openPassword)
    }
}