package domain.student

data class Student(
    val documentNumber: DocumentNumber,
    val name: String,
    val email: Email
) {
    val phones: MutableList<Phone> = mutableListOf()
    val password: String? = null

    fun addPhone(ddd: String, number: String) {
        this.phones.add(Phone(ddd, number))
    }
}