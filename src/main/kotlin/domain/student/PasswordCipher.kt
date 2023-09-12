package domain.student

interface PasswordCipher {

    fun encryptPassword(): String

    fun validateCipherPassword(cipherPassword: String, openPassword: String): Boolean
}