package application.register

import application.RegisterStudent
import domain.EventPublisher
import domain.Listener
import domain.student.DocumentNumber
import domain.student.EventListener
import infrastructure.student.StudentRepositoryInMemory
import org.junit.jupiter.api.Assertions.*
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