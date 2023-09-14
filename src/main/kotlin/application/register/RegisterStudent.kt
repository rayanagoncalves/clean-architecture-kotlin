package application

import application.register.RegisterStudentDto
import domain.EventPublisher
import domain.student.RegisteredStudent
import domain.student.StudentRepository

class RegisterStudent(
    private val studentRepository: StudentRepository,
    private val eventPublisher: EventPublisher) {

    //command
    fun execute(student: RegisterStudentDto) {
        val newStudent = student.createStudent()
        studentRepository.register(newStudent)
        val registeredStudent = RegisteredStudent(newStudent.documentNumber)
        eventPublisher.publish(registeredStudent)
    }
}