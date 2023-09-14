package br.com.rayanagoncalves.escola.academico.domain.student

import br.com.rayanagoncalves.escola.academico.domain.Event
import java.time.LocalDateTime

data class RegisteredStudent(
    val documentNumber: DocumentNumber,
    val moment: LocalDateTime = LocalDateTime.now()
): Event {

    override fun moment(): LocalDateTime {
        return this.moment
    }
}