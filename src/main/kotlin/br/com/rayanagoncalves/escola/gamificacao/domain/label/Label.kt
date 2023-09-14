package br.com.rayanagoncalves.escola.gamificacao.domain.label

import br.com.rayanagoncalves.escola.academico.domain.student.DocumentNumber

data class Label(
    val studentDocumentNumber: DocumentNumber,
    val name: String
)
