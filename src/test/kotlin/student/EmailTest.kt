package student

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

internal class EmailTest {

    @Test
    fun shouldNotCreateEmailWithInvalidAddress() {
        assertThrows<IllegalArgumentException> { Email("") }
        assertThrows<IllegalArgumentException> { Email("invalidEmail") }
    }

    @Test
    fun shouldCreateEmailWithValidAddress() {
        val address = "rayana@hotmail.com"
        val email = Email(address)

        assertEquals(address, email.address)
    }
}