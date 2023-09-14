package br.com.rayanagoncalves.escola.academico.infrastructure

import br.com.rayanagoncalves.escola.academico.domain.recommendation.SendEmailRecommendation
import br.com.rayanagoncalves.escola.academico.domain.student.Student

class SendRecommendationEmailJavaMail: SendEmailRecommendation {

    override fun sendTo(recommended: Student) {
        TODO("Not yet implemented")
    }
}