package student

interface StudentRepository {

    fun register(student: Student)

    fun findByDocumentNumber(documentNumber: DocumentNumber): Student

    fun listAllRegisteredStudents()

}