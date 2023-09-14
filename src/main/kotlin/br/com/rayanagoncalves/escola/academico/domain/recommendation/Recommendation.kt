package br.com.rayanagoncalves.escola.academico.domain.recommendation

import br.com.rayanagoncalves.escola.academico.domain.student.Student
import java.time.LocalDateTime

data class Recommendation(
    val recommended: Student,
    val recommender: Student,
    val recommendationDate: LocalDateTime = LocalDateTime.now()
)