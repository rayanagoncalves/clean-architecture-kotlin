package domain.recommendation

import domain.student.Student
import java.time.LocalDateTime

data class Recommendation(
    val indicated: Student,
    val indicator: Student,
    val indicationDate: LocalDateTime = LocalDateTime.now()
)