package domain

data class Student(
    val documentNumber: String,
    val name: String,
    val email: Email
) {
    private val phones: MutableList<Phone> = mutableListOf()

    fun addPhone(ddd: String, number: String) {
        this.phones.add(Phone(ddd, number))
    }
}