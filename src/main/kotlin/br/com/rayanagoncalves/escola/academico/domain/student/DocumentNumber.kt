package br.com.rayanagoncalves.escola.academico.domain.student

data class DocumentNumber(
    var number: String
) {

    init {
        this.number = validateNumber()
    }

    fun validateNumber(): String {
        val regex = Regex("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        if(number.isNullOrBlank() || !regex.matches(number)) {
            throw IllegalArgumentException("Invalid document number.")
        }

        return number
    }
}