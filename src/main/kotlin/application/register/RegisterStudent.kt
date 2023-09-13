package application

import application.register.RegisterStudentDto
import domain.student.StudentRepository

class RegisterStudent(private val studentRepository: StudentRepository) {

    //command
    fun execute(student: RegisterStudentDto) {
        val newStudent = student.createStudent()
        studentRepository.register(newStudent)
    }
}