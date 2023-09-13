import application.RegisterStudent
import application.register.RegisterStudentDto
import infrastructure.student.StudentRepositoryInMemory

fun main() {
    val name = "Fulano da Silva"
    val documentNumber = "123456"
    val email = "fulano.silva@email.com"

    val registerStudent = RegisterStudent(StudentRepositoryInMemory())
    registerStudent.execute(RegisterStudentDto(name, documentNumber, email))
}