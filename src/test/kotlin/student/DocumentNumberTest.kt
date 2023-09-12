package student

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