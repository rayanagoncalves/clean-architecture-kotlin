package br.com.rayanagoncalves.escola.gamificacao.application

import br.com.rayanagoncalves.escola.gamificacao.domain.badge.Badge
import br.com.rayanagoncalves.escola.gamificacao.domain.badge.BadgeRepository
import br.com.rayanagoncalves.escola.shared.domain.DocumentNumber
import br.com.rayanagoncalves.escola.shared.domain.event.Event
import br.com.rayanagoncalves.escola.shared.domain.event.EventType
import br.com.rayanagoncalves.escola.shared.domain.event.Listener

class GenerateNewStudentBadge(private val badgeRepository: BadgeRepository): Listener() {

    override fun listen(event: Event) {
        val newStudentBadge = Badge(studentDocumentNumber = event.information().get("cpf") as DocumentNumber, name = "new Student")
       badgeRepository.add(newStudentBadge)
    }

    override fun canProcess(event: Event): Boolean {
        return event.type() == EventType.REGISTERED_STUDENT
    }


}