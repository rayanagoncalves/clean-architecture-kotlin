package domain.student

import domain.Event
import java.time.LocalDateTime

data class RegisteredStudent(
    val documentNumber: DocumentNumber,
    val moment: LocalDateTime = LocalDateTime.now()
): Event {

    override fun moment(): LocalDateTime {
        return this.moment
    }
}