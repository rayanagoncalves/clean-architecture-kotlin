package br.com.rayanagoncalves.escola.academico.domain.recommendation

import br.com.rayanagoncalves.escola.academico.domain.student.Student

interface SendEmailRecommendation {

    fun sendTo(recommended: Student)

}