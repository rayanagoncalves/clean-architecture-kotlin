package domain.student

interface PasswordCipher {

    fun encryptPassword(password: String): String

    fun validateCipherPassword(cipherPassword: String, openPassword: String): Boolean
}