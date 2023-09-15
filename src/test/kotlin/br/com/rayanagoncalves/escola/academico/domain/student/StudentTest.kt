package br.com.rayanagoncalves.escola.academico.domain.student

import br.com.rayanagoncalves.escola.shared.domain.DocumentNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class StudentTest {

    private val student = Student(
        documentNumber = DocumentNumber("123.456.789-10"),
        name = "Fulano",
        email = Email("fulano@email.com")
    )

    @Test
    fun shouldNotAddMoreThan2PhonesToStudent() {
        assertThrows<IllegalArgumentException> {
            student.addPhone("81", "12345678")
            student.addPhone("82", "12345679")
            student.addPhone("80", "12345673")
        }
    }

    @Test
    fun shouldPermitAdd1PhoneToStudent() {
        student.addPhone("81", "12345678")
        assertEquals(1, student.phones.size)
    }

    @Test
    fun shouldPermitAdd2PhonesToStudent() {
        student.addPhone("81", "12345678")
        student.addPhone("82", "12345679")
        assertEquals(2, student.phones.size)
    }
}