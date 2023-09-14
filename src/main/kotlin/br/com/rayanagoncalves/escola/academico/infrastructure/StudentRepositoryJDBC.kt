package br.com.rayanagoncalves.escola.academico.infrastructure

import br.com.rayanagoncalves.escola.academico.domain.student.*
import java.sql.Connection
import java.sql.SQLException

class StudentRepositoryJDBC(private val connection: Connection): StudentRepository {

    override fun register(student: Student) {
        try {
            var sql = "INSERT INTO STUDENT VALUES(?,?,?)"
            var preparedStatement = connection.prepareStatement(sql)
            preparedStatement.setString(1, student.documentNumber.number)
            preparedStatement.setString(2, student.name)
            preparedStatement.setString(3, student.email.address)

            preparedStatement.execute()

            sql = "INSERT INTO PHONE VALUES(?, ?)"
            preparedStatement = connection.prepareStatement(sql)
            for (phone: Phone in student.phones) {
                preparedStatement.setString(1, phone.ddd)
                preparedStatement.setString(2, phone.number)
                preparedStatement.execute()
            }
        } catch(e: SQLException) {
            throw RuntimeException(e)
        }
    }

    override fun findByDocumentNumber(documentNumber: DocumentNumber): Student {
        try {
            var sql = "SELECT id, name, email FROM STUDENT WHERE document_number = ?"
            var preparedStatement = connection.prepareStatement(sql)
            preparedStatement.setString(1, documentNumber.number)

            var result = preparedStatement.executeQuery()
            val found = result.next()
            if(!found) {
                throw RuntimeException()
            }

            val name = result.getString("name")
            val email = Email(result.getString("email"))
            val student = Student(documentNumber, name, email)

            val id = result.getLong("id")
            sql = "SELECT ddd, number FROM PHONE WHERE STUDENT_ID = ?"
            preparedStatement = connection.prepareStatement(sql)
            preparedStatement.setLong(1, id)
            result = preparedStatement.executeQuery()
            while(result.next()) {
                val ddd = result.getString("ddd")
                val number = result.getString("number")
                student.addPhone(ddd, number)
            }

            return student
        } catch(e: SQLException) {
            throw RuntimeException(e)
        }

    }

    override fun listAllRegisteredStudents(): List<Student> {
        try {
            var sql = "SELECT id, name, email FROM STUDENT"
            var preparedStatement = connection.prepareStatement(sql)
            var result = preparedStatement.executeQuery()
            val studentList = mutableListOf<Student>()
            while(result.next()) {
                val name = result.getString("name")
                val email = Email(result.getString("email"))
                val documentNumber = DocumentNumber(result.getString("document_number"))
                val student = Student(documentNumber, name, email)

                val id = result.getLong("id")
                sql = "SELECT ddd, number FROM PHONE WHERE STUDENT_ID = ?"
                preparedStatement = connection.prepareStatement(sql)
                preparedStatement.setLong(1, id)
                result = preparedStatement.executeQuery()
                while(result.next()) {
                    val ddd = result.getString("ddd")
                    val number = result.getString("number")
                    student.addPhone(ddd, number)
                }

                studentList.add(student)
            }

            return studentList

        } catch(e: SQLException) {
            throw RuntimeException(e)
        }
    }
}