package br.com.rayanagoncalves.escola.academico.application

import br.com.rayanagoncalves.escola.academico.domain.student.RegisteredStudent
import br.com.rayanagoncalves.escola.academico.domain.student.StudentRepository
import br.com.rayanagoncalves.escola.shared.domain.event.EventPublisher

class RegisterStudent(
    private val studentRepository: StudentRepository,
    private val eventPublisher: EventPublisher
) {

    //command
    fun execute(student: RegisterStudentDto) {
        val newStudent = student.createStudent()
        studentRepository.register(newStudent)
        val registeredStudent = RegisteredStudent(newStudent.documentNumber)
        eventPublisher.publish(registeredStudent)
    }
}