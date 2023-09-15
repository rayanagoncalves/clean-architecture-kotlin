package br.com.rayanagoncalves.escola.academico.application

import br.com.rayanagoncalves.escola.academico.domain.student.EventListener
import br.com.rayanagoncalves.escola.academico.infrastructure.StudentRepositoryInMemory
import br.com.rayanagoncalves.escola.shared.domain.DocumentNumber
import br.com.rayanagoncalves.escola.shared.domain.event.EventPublisher
import br.com.rayanagoncalves.escola.shared.domain.event.Listener
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RegisterStudentTest {

    @Test
    fun shouldCreateStudent() {
        val studentRepositoryInMemory = StudentRepositoryInMemory()
        val listeners = mutableListOf<Listener>()
        listeners.add(EventListener())
        val eventPublisher = EventPublisher(listeners)
        val useCase = RegisterStudent(studentRepositoryInMemory, eventPublisher)

        val registerStudentDto = RegisterStudentDto("Fulano", "705.693.503-04", "fulano@email.com")
        useCase.execute(registerStudentDto)

        val studentFound = studentRepositoryInMemory.findByDocumentNumber(DocumentNumber("705.693.503-04"))

        assertEquals("Fulano", studentFound.name)
        assertEquals("705.693.503-04", studentFound.documentNumber.number)
        assertEquals("fulano@email.com", studentFound.email.address)
    }
}