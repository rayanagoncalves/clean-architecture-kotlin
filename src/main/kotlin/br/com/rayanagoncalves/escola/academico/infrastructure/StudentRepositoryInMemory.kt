package br.com.rayanagoncalves.escola.academico.infrastructure

import br.com.rayanagoncalves.escola.academico.domain.student.Student
import br.com.rayanagoncalves.escola.academico.domain.student.StudentRepository
import br.com.rayanagoncalves.escola.shared.domain.DocumentNumber

class StudentRepositoryInMemory(private var studentList: MutableList<Student> = mutableListOf()): StudentRepository {

    override fun register(student: Student) {
        this.studentList.add(student)
    }

    override fun findByDocumentNumber(documentNumber: DocumentNumber): Student {
        return this.studentList.stream().filter{ it.documentNumber.number == documentNumber.number }.findFirst().get()
    }

    override fun listAllRegisteredStudents(): List<Student> {
        return this.studentList
    }


}