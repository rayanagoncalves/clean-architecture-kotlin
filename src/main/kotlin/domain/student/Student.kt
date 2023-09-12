package domain.student

data class Student(
    val documentNumber: DocumentNumber,
    val name: String,
    val email: Email,
    val password: String
) {
    val phones: MutableList<Phone> = mutableListOf()

    fun addPhone(ddd: String, number: String) {
        this.phones.add(Phone(ddd, number))
    }
}