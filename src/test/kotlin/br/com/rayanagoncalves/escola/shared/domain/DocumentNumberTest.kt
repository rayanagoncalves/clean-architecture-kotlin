package br.com.rayanagoncalves.escola.shared.domain

import br.com.rayanagoncalves.escola.academico.domain.student.Email
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class DocumentNumberTest {

    @Test
    fun shouldNotCreateDocumentNumberWithInvalidNumber() {
        assertThrows<IllegalArgumentException> { Email("") }
        assertThrows<IllegalArgumentException> { Email("123") }
    }

    @Test
    fun shouldCreateDocumentWithValidNumber() {
        val number = "037.698.350-77"
        val documentNumber = DocumentNumber(number)

        assertEquals(number, documentNumber.number)
    }
}