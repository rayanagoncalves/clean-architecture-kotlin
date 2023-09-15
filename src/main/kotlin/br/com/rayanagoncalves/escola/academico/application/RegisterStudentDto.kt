package br.com.rayanagoncalves.escola.academico.application

import br.com.rayanagoncalves.escola.academico.domain.student.Email
import br.com.rayanagoncalves.escola.academico.domain.student.Student
import br.com.rayanagoncalves.escola.shared.domain.DocumentNumber

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