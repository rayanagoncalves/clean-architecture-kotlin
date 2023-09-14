package domain.student

import domain.Event
import domain.Listener
import java.time.format.DateTimeFormatter

class EventListener: Listener() {

    override fun listen(event: Event) {
        val documentNumber = (event as RegisteredStudent).documentNumber.number
        val formattedMoment = event.moment().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"))
        println("Aluno com CPF $documentNumber matriculado em $formattedMoment")
    }

    override fun canProcess(event: Event): Boolean {
        return event is RegisteredStudent
    }
}