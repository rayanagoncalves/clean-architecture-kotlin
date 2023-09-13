package domain.student

data class Student(
    val documentNumber: DocumentNumber,
    val name: String,
    val email: Email
) {
    val phones: MutableList<Phone> = mutableListOf()
    val password: String? = null

    fun addPhone(ddd: String, number: String) {
        if(phones.size == 2) {
            throw IllegalArgumentException("Número máximo de telefones atingido.")
        }
        this.phones.add(Phone(ddd, number))
    }
}