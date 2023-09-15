import br.com.rayanagoncalves.escola.academico.application.RegisterStudent
import br.com.rayanagoncalves.escola.academico.application.RegisterStudentDto
import br.com.rayanagoncalves.escola.academico.domain.student.EventListener
import br.com.rayanagoncalves.escola.academico.infrastructure.StudentRepositoryInMemory
import br.com.rayanagoncalves.escola.shared.domain.event.EventPublisher
import br.com.rayanagoncalves.escola.shared.domain.event.Listener

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