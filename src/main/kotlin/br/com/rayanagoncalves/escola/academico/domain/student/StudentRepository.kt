package br.com.rayanagoncalves.escola.academico.domain.student

import br.com.rayanagoncalves.escola.shared.domain.DocumentNumber

interface StudentRepository {

    fun register(student: Student)

    fun findByDocumentNumber(documentNumber: DocumentNumber): Student

    fun listAllRegisteredStudents(): List<Student>

}