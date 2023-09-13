package domain.student

import java.time.format.DateTimeFormatter

class EventListener {

    fun listen(event: RegisteredStudent) {
        val formattedMoment = event.moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"))
        println("Aluno com cpf ${event.documentNumber} matriculado em $formattedMoment")
    }
}