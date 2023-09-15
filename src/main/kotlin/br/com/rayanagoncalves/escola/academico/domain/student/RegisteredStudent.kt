package br.com.rayanagoncalves.escola.academico.domain.student

import br.com.rayanagoncalves.escola.shared.domain.DocumentNumber
import br.com.rayanagoncalves.escola.shared.domain.event.Event
import br.com.rayanagoncalves.escola.shared.domain.event.EventType
import java.time.LocalDateTime

data class RegisteredStudent(
    val documentNumber: DocumentNumber,
    val moment: LocalDateTime = LocalDateTime.now()
): Event {

    override fun moment(): LocalDateTime {
        return this.moment
    }

    override fun type(): EventType {
        return EventType.REGISTERED_STUDENT
    }

    override fun information(): Map<String, Any> {
        return mapOf("cpf" to documentNumber)
    }
}