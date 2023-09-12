package domain.student

interface StudentRepository {

    fun register(student: Student)

    fun findByDocumentNumber(documentNumber: DocumentNumber): Student

    fun listAllRegisteredStudents(): List<Student>

}