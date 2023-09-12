package infrastructure.student

import domain.student.DocumentNumber
import domain.student.Student
import domain.student.StudentRepository

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