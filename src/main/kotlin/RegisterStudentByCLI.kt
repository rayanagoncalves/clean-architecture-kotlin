import application.RegisterStudent
import application.register.RegisterStudentDto
import domain.EventPublisher
import domain.Listener
import domain.student.EventListener
import infrastructure.student.StudentRepositoryInMemory

fun main() {
    val name = "Fulano da Silva"
    val documentNumber = "123.456.789-10"
    val email = "fulano.silva@email.com"

    val listeners = mutableListOf<Listener>()
    val eventPublisher = EventPublisher(listeners)
    eventPublisher.add(EventListener())
    val registerStudent = RegisterStudent(StudentRepositoryInMemory(), eventPublisher)
    registerStudent.execute(RegisterStudentDto(name, documentNumber, email))
}