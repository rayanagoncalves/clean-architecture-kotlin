package application.register

import domain.student.DocumentNumber
import domain.student.Email
import domain.student.Student

data class RegisterStudentDto(
    val name: String,
    val documentNumber: String,
    val email: String
) {

    fun createStudent(): Student {
        return Student(
            documentNumber = DocumentNumber(documentNumber),
            name = name,
            email = Email(email)
        )
    }
}