package br.com.rayanagoncalves.escola.academico.domain.student

import br.com.rayanagoncalves.escola.shared.domain.DocumentNumber

class StudentFactory(private var student: Student) {

    fun withNameDocumentNumberAndEmail(name: String, documentNumber: String, email: String): Student {
        this.student = Student(DocumentNumber(documentNumber), name, Email(email))
        return this.student
    }

    fun withPhone(ddd: String, number: String): Student {
        this.student.addPhone(ddd, number)
        return this.student
    }

    fun build(): Student {
        return this.student
    }
}

