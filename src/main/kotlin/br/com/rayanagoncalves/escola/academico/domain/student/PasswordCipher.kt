package br.com.rayanagoncalves.escola.academico.domain.student

interface PasswordCipher {

    fun encryptPassword(password: String): String

    fun validateCipherPassword(cipherPassword: String, openPassword: String): Boolean
}