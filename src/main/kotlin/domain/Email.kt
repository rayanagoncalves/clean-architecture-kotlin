package domain

data class Email(
    var address: String
) {

    init {
        this.address = validateEmail()
    }

    fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")

        if(address.isNullOrBlank() || !regex.matches(address)) {
            throw IllegalArgumentException("Invalid e-mail.")
        }

        return address
    }
}