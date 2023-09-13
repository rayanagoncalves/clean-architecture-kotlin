package domain.recommendation

import domain.student.Student

interface SendEmailRecommendation {

    fun sendTo(recommended: Student)

}