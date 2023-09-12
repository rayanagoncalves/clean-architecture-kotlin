package domain.student

data class Phone(
    var ddd: String,
    var number: String
) {

    init {
        this.ddd = validateDdd()
        this.number = validateNumber()
    }

    fun validateDdd(): String {
        val regex = Regex("\\d{2}")
        if(!regex.matches(ddd)) {
            throw IllegalArgumentException("Invalid ddd.")
        }

        return ddd
    }

    fun validateNumber(): String {
        val regex = Regex("\\d{8}|\\d{9}")
        if(!regex.matches(number)) {
            throw IllegalArgumentException("Invalid number.")
        }

        return number
    }
}