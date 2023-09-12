package student

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

internal class PhoneTest {

    @Test
    fun shouldNotCreatePhoneWithInvalidDDD() {
        assertThrows<IllegalArgumentException> { Phone("", "12345678") }
        assertThrows<IllegalArgumentException> { Phone("123", "12345678") }
    }

    @Test
    fun shouldCreatePhoneWithValidDDD() {
        val ddd = "81"
        val phone = Phone(ddd, "12345678")

        assertEquals(ddd, phone.ddd)
    }

    @Test
    fun shouldNotCreatePhoneWithInvalidNumber() {
        assertThrows<IllegalArgumentException> { Phone("81", "") }
        assertThrows<IllegalArgumentException> { Phone("81", "1234567") }
    }

    @Test
    fun shouldCreatePhoneWithValidNumber() {
        val number = "12345678"
        val phone = Phone("81", number)

        assertEquals(number, phone.number)
    }
}