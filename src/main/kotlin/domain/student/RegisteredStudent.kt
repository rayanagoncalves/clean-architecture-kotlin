package domain.student

import domain.Event
import java.time.LocalDateTime

data class RegisteredStudent(
    private val documentNumber: DocumentNumber,
    private val moment: LocalDateTime = LocalDateTime.now()
): Event {

    override fun moment(): LocalDateTime {
        return this.moment
    }
}